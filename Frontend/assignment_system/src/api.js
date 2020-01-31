const axios = require('axios');
export const getOptions = () => axios.get('http://localhost:8080/getAllIdentyfikatoryPlanuStudiow');

export const getSubjectData = (iden) => axios({
    method: 'post',
    url: 'http://localhost:8080/getAllKurs',
    data: iden
});

export const getEntrustPlan = (iden) => axios({
    method: 'post',
    url: 'http://localhost:8080/getPlanPowierzen',
    data: iden
});

export const saveEntrustPlan = (plan) => axios({
    method: 'put',
    url: 'http://localhost:8080/savePlanPowierzen',
    data: plan
});


/*
{
    "powierzenia": [],
    "nazwa": "standard",
    "identyfikatorSemestru": null,
    "zatwierdzony": false,
    "id": 0
}
*/
export const getStaff = () => axios.get('http://localhost:8080/allProwadzacy');

export const saveEntrust = (plan) => axios({
    method: 'put',
    url: 'http://localhost:8080/savePowierzenie',
    data: plan
});

/*
{
        "powierzenia": [
        	{
        		"id":0,
        		"prowadzacy" :{
        			"id":24
        		},
        		"kurs":{
        			"id":8
        		},
        		"liczbaGodzin":20,
        		"zgodaProwadzacego":"true"
        	}],
        "nazwa": "standard",
        "identyfikatorSemestru": {
	"cyklKsztalcenia":"Zima 2019/2020",
	"kierunekStudiow":"Informatyka",
	"specjalnosc":"Inżynieria oprogramowania",
	"numerSemestru":1
},
        "zatwierdzony": false,
        "id": 22
    }
 */

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