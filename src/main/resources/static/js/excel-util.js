import * as XLSX from 'xlsx'

// var XLSX = require("xlsx");

/**
 * {
 *     name:'xxx.xlsx',//存储名
 *     num: 1,//sheet 数
 *     sheets: [
 *         {
 *             name: 'sheet1',//sheet 名
 * 			   type: 'json|array', //数据类型
 *             header:[h1: 'h1', h2: 'h2', ...],//表头,json, 表头对应的字段
 * 			   fields: ['h1', 'h2', ...],
 *             data:[
 *                 {...}, {...}, {...}
 *              ]
 *         }
 *     ]
 * }
 * @param json
 */
function exportExcel(json) {
    const workbook = XLSX.utils.book_new();
    const num = json['num'];
    for (let i = 0; i < num; i++) {
        //解析sheet
        const sheet = json['sheets'][i];
        let type = sheet['type'];
        let worksheet;
        if (type === 'json') {
            worksheet = XLSX.utils.json_to_sheet(sheet['data'], {
                header: sheet['fields']
            });
            //替换表头
            const titles = sheet['header'];
            const range = XLSX.utils.decode_range(worksheet['!ref'])
            for (let c = range.s.c; c <= range.e.c; c++) {
                const head = XLSX.utils.encode_col(c) + '1'
                worksheet[head].v = titles[worksheet[head].v]
            }
        } else { //array
            worksheet = XLSX.utils.aoa_to_sheet(sheet['data']);
        }
        XLSX.utils.book_append_sheet(workbook, worksheet, sheet['name']);
    }

    XLSX.writeFile(workbook, json['name'], {
        bookType: 'xlsx'
    });
}

export {
    exportExcel
}