function set(){
  let editor = document.querySelector(".ql-editor").innerHTML;
  let b_Contents = document.querySelector("#b_Contents");
  let submit = document.querySelector("#submit");
  b_Contents.value = editor;
}