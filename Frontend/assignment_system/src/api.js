const axios = require('axios');


let origin = process.env.REACT_APP_API_URI;
if(process.env.REACT_APP_API_URI === "prod"){
    origin = "http://" + window.location.hostname + ":" + "30466";
}

export const getOptions = () => axios({
    method: 'get',
    url: origin + '/getAllIdentyfikatoryPlanuStudiow'
});

export const getSubjectData = (iden) => axios({
    method: 'post',
    url: origin + '/getAllKurs',
    data: iden,
    headers : attachAuthenticationToken()
});

export const getEntrustPlan = (iden) => axios({
    method: 'post',
    url: origin + '/getPlanPowierzen',
    data: iden,
    headers : attachAuthenticationToken()
});

export const saveEntrustPlan = (plan) => axios({
    method: 'post',
    url: origin + '/savePlanPowierzen',
    data: plan,
    headers : attachAuthenticationToken()
});

export const approveEntrustPlan = (plan) => axios({
    method: 'post',
    url: origin + '/approvePlanPowierzen',
    data: plan,
    headers : attachAuthenticationToken()
});

export const returnEntrustPlan = (plan) => axios({
    method: 'post',
    url: origin + '/returnPlanPowierzen',
    data: plan,
    headers : attachAuthenticationToken()
});

export const loginEndpoint = (user) => axios({
    method: 'post',
    url: origin + '/authenticate',
    data: user,
    headers:{
        "Content-Type":"application/json"
    }
});

export const getStaff = () => axios({
    method: 'get',
    url: origin + '/allProwadzacy',
    headers : attachAuthenticationToken()
});

export const saveEntrust = (plan) => axios({
    method: 'post',
    url: origin + '/savePowierzenie',
    data: plan,
    headers : attachAuthenticationToken()
});

export const removeEntrust = (plan) => axios({
    method: 'post',
    url: origin + '/removePowierzenie',
    data: plan,
    headers : attachAuthenticationToken()
});

const attachAuthenticationToken = () =>{
    if(localStorage.getItem("token"))
    {
        return {
            Authorization: "Bearer " + localStorage.getItem("token")
        }
    }
    else {
        return {};
    }
}





/*
{
    "powierzenia": [],
    "nazwa": "standard",
    "identyfikatorSemestru": null,
    "zatwierdzony": false,
    "id": 0
}
*/


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