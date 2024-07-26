$(document).ready(function() {
    $('#addAutoForm').on('click', '#btn-guardar', function(event) {
        event.preventDefault();

        var formData = {
            id: $('#id').val(),
            marca: $('#marca').val(),
            modelo: $('#modelo').val(),
            anio: $('#anio').val(),
            placa: $('#placa').val()
        };
        $.ajax({
            url: '/guardar',
            type: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(formData),
            success: function(response) {
                var parsedResponse;
                parsedResponse = JSON.parse(response);
                if (parsedResponse.success) {
                    $('#addAutoModal').modal('hide');
                    location.reload();
                } else {
                    alert('Error al agregar el auto: ' + parsedResponse.message);
                }
            },
        });
    });