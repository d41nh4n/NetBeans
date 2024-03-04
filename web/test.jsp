<%-- 
    Document   : test
    Created on : Mar 1, 2024, 9:02:23 PM
    Author     : Dai Nhan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>JSON Example</title>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
        $(document).ready(function() {
            // AJAX request to fetch JSON data
            $.ajax({
                url: 'https://countriesnow.space/api/v0.1/countries/currency', 
                dataType: 'json',
                success: function(data) {
                    // Parse JSON data
                    var jsonData = data.data;

                    var html = '<ul>';
                    $.each(jsonData, function(index, item) {
                        html += '<li>' + item.name + ': ' + item.currency + '</li>';
                    });
                    html += '</ul>';
                    $('#output').html(html);
                },
                error: function(xhr, status, error) {
                    console.log('Error fetching JSON data: ' + error);
                }
            });
        });
    </script>
</head>
<body>
    <div id="output"></div>
</body>
</html>
