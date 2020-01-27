const axios = require('axios');
export const getOptions = () => axios.get('http://localhost:8080/getAllIdentyfikatoryPlanuStudiow');
export const getSubjectData = (iden) => axios({
    method: 'post',
    url: 'http://localhost:8080/getAllKurs',
    data: iden
});

//export const getOptions = () => import('./mock/options').then(d => d.default)

/*export const getOptions = [{
    "cyklKsztalcenia": "Zima 2019/2020",
    "kierunekStudiow": "Informatyka",
    "specjalnosc": "Inżynieria oprogramowania",
    "numerSemestru": 1
},
    {
        "cyklKsztalcenia": "Zima 2019/2021",
        "kierunekStudiow": "Informatyka dupa",
        "specjalnosc": "Inżynieria oprogramowania",
        "numerSemestru": 2
    },
    {
        "cyklKsztalcenia": "Zima 2019/2021",
        "kierunekStudiow": "Informatyka dupa",
        "specjalnosc": "Inżynieria oprogramowania",
        "numerSemestru": 2
    },
    {
        "cyklKsztalcenia": "Zima 2019/2021",
        "kierunekStudiow": "Informatyka dupa",
        "specjalnosc": "Inżynieria oprogramowania dupa",
        "numerSemestru": 2
    },
    {
        "cyklKsztalcenia": "Zima 2019/2021",
        "kierunekStudiow": "Informatyka dupa",
        "specjalnosc": "Inżynieria oprogramowania dupa",
        "numerSemestru": 3
    }]*/