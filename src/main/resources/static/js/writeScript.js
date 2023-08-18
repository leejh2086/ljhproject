function set(){
  let editor = document.querySelector(".ql-editor").innerHTML;
  let bDetail = document.querySelector("#b_Detail");
  let submit = document.querySelector("#submit");
  bDetail.value = editor;
}