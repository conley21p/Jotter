<%--
  Created by IntelliJ IDEA.
  User: Jacob Radtke
  Date: 4/6/2022
  Time: 2:20 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<p><input type="file"  accept="image/*" name="image" id="file"  onchange="loadFile(event)" style="display: none;"></p>
<p><label for="file" style="cursor: pointer;">Upload Image</label></p>
<p><img id="output" width="200" /></p>

<script>
    let loadFile = function(event) {
        let image = document.getElementById('output');
        image.src = URL.createObjectURL(event.target.files[0]);
    };
</script>