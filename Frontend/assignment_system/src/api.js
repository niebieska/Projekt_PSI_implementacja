const axios = require('axios');
//export const getSubjectData = () => axios('http://localhost:8080/getAllIdentyfikatoryPlanuStudiow');
export const getSubjectData = () => import('./mock/getAllIdentyfikatoryPlanuStudiow').then(d => d.default);

export const getOptions = () => import('./mock/options').then(d => d.default)