function set(){
  let editor = document.querySelector(".ql-editor").innerHTML;
  let bContents = document.querySelector("#b_Contents");
  let submit = document.querySelector("#submit");
  bContents.value = editor;
}