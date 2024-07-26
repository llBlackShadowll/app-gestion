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

    $('#table-autos').on('click', '#btn-editar', function() {
        console.log("prueba boton");
        var $row = $(this).closest('tr');
        var id = $row.find('td').eq(0).text();
        var marca = $row.find('td').eq(1).text();
        var modelo = $row.find('td').eq(2).text();
        var anio = $row.find('td').eq(3).text();
        var placa = $row.find('td').eq(4).text();
        $('#id').val(id);
        $('#marca').val(marca);
        $('#modelo').val(modelo);
        $('#anio').val(anio);
        $('#placa').val(placa);
        console.log(id);
        $('#addAutoModal').modal('show');
        });


        $('#addAutoForm').on('click', '#btn-actualizar',function(event) {
                event.preventDefault();

                var formData = {
                    marca: $('#id').val(),
                    marca: $('#marca').val(),
                    modelo: $('#modelo').val(),
                    anio: $('#anio').val(),
                    placa: $('#placa').val()
                };

                // Enviar los datos al servidor con AJAX
                $.ajax({
                    url: '/actualizar', // Ruta del endpoint en el controlador
                    type: 'POST',
                    contentType: 'application/json',
                    data: JSON.stringify(formData),
                    success: function(response) {
                        var parsedResponse;
                        try {
                            parsedResponse = JSON.parse(response);
                        } catch (e) {
                            console.error('Error parsing response:', response);
                            alert('Error al procesar la respuesta del servidor. Ver consola para detalles.');
                            return;
                        }

                        if (parsedResponse.success) {
                            $('#updateAutoModal').modal('hide');
                            location.reload(); // Recargar la página para reflejar los cambios
                        } else {
                            alert('Error al actualizar el auto: ' + parsedResponse.message);
                        }
                    },
                    error: function(xhr, status, error) {
                        console.error('Error:', error);
                        alert('Error al procesar la solicitud. Ver consola para detalles.');
                    }
                });
            });





});

