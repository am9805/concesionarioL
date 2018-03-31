function showModal(id){
    $('#'+id).modal('open');
}

$(document).ready(function(){
    // the "href" attribute of the modal trigger must specify the modal ID that wants to be triggered
    $('.modal').modal();
    //$('select').formSelect();
  });
  
  
  function cambiaInputCreate(){
     let color = $('#createColor').val();
     let cilindraje = $('#createCilindraje').val();
     let precio = $('#createPrecio').val();
     let garantia = $('#createGarantia').val();
     
  }