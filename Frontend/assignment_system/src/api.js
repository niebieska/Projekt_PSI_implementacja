const axios = require('axios');
//export const getSubjectData = () => axios('http://localhost:8080/getAllIdentyfikatoryPlanuStudiow');
export const getSubjectData = () => import('./Common/Mocks/getAllIdentyfikatoryPlanuStudiow').then(d => d.default);

//export const getOptions = () => import('./mock/options').then(d => d.default)

export const getOptions = [{
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
    }]