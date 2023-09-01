function set(){
  let editor = document.querySelector(".ql-editor").innerHTML;
  let bContents = document.querySelector("#b_Contents");
  let select = document.querySelector("#select");
  bContents.value = editor;
}