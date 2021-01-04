document.getElementById('curiosity').addEventListener('click',buttonAction)

document.getElementById('opportunity').addEventListener('click',buttonAction)

document.getElementById('spirit').addEventListener('click',buttonAction)

function buttonAction(){
    const roverId=this.id
    document.getElementById('apiRoverData').setAttribute('value',roverId)

}

const roverType= getUrlParam("apiRoverData")
highLightButton(roverType)

let marsSol=getUrlParam("marsSol")
document.getElementById("marsSol").setAttribute("value",marsSol)



function getUrlParam(name) {
    name = name.replace(/[\[]/, '\\[').replace(/[\]]/, '\\]');
    var regex = new RegExp('[\\?&]' + name + '=([^&#]*)');
    var results = regex.exec(location.search);
    return results === null ? '' : decodeURIComponent(results[1].replace(/\+/g, ' '));
}

function highLightButton(roverType){
    if(roverType ==''){
        roverType='Opportunity'
    }
    document.getElementById(roverType).checked=true


}






