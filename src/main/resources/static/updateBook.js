const container_input=document.querySelector('.container-label');
const erori=document.querySelectorAll('.error li');
const span_erori=document.querySelector('.span_erori');

container_input.addEventListener('input',(e)=>{
    checkInput(e.target.id);
})
function checkInput(elemName){
    let allInput=document.querySelectorAll('input');
        let val;
        if(elemName==='title'){
            val=allInput[0].value;
        }else if(elemName==='author'){
            val=allInput[1].value;
        }else if(elemName==='type'){
            val=allInput[2].value;
        }
        if(val.length<=0){
            span_erori.style.display="unset";
            document.querySelector(`.${elemName}`).style.display="unset";
        }else if(val.length>0){
            document.querySelector(`.${elemName}`).style.display="none";
        }

}