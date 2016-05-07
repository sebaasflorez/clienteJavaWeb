function ListarUsuarios(){
    $.ajax({
                method: 'GET',
                url: 'srvListadoClientes',
                //data: {},
                datatype: 'json',
                success: function (data) {
                    console.log(data);
                    var salida = "<table class='table'><thead><tr><th>Tipo</th><th>Número</th><th>Nombre</th><th>Apellido</th><th>Teléfono</th><th>Dirección</th></tr></thead><tbody>";
                    data.forEach(function (dato) {
                        salida += "<tr><td>" + dato['tipo_documento'] + "</td><td>" + dato['numero_documento'] + "</td><td>" + dato['nombres'] + "</td><td>" + dato['apellidos'] + "</td><td>" + dato['telefono'] + "</td><td>" + dato['direccion'] + "</td></tr>"
                    });
                    salida += "</tbody></table>";
                    $("#reporte").html(salida);
                }
    });
}

