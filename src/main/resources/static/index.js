document.getElementById('curiosity').addEventListener('click',buttonAction)

document.getElementById('opportunity').addEventListener('click',buttonAction)

document.getElementById('spirit').addEventListener('click',buttonAction)


function buttonAction(){
    const roverId=this.id
    document.getElementById('apiRoverData').setAttribute('value',roverId)
    // document.getElementById('formRover').submit()

}
