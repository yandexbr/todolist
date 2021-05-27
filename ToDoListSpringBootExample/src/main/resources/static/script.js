function findById() {
        var id = document.getElementById("search_field").value;
        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function () {
            if (this.readyState == 3 && this.status == 200) {
                var task = JSON.parse(this.responseText);
                var html = '<tr>\n' +
                    '        <th>Task id</th>\n' +
                    '        <th>Task name</th>\n' +
                    '        <th>Task description</th>\n' +
                    '        <th>Delete</th>\n' +
                    '    </tr>';
                html = html + '<tr><td>' + task.id + '</td>\n' +
                    '        <td>' + task.name + '</td>\n' +
                    '        <td>' + task.description + '</td>\n' +
                    '        <td><button onclick="deleteTask(' + id + ')">Delete</button></td></tr>';
                document.getElementById("tasksList").innerHTML = html;
            }
        };
        xhttp.open("GET", "http://localhost:8080/tasks/find/" + id, true);
        xhttp.send();
    }

function deleteTask(id) {
        var xhttp = new XMLHttpRequest();
        xhttp.open("DELETE", "http://localhost:8080/tasks/delete/" + id, true);
        xhttp.send();
    }

function createTask() {
        var taskName = document.getElementById("task_name").value;
        var taskDescription = document.getElementById("task_description").value;

        var xmlhttp = new XMLHttpRequest();   // new HttpRequest instance
        xmlhttp.open("POST", "http://localhost:8080/tasks/save");
        xmlhttp.setRequestHeader("Content-Type", "application/json");
        xmlhttp.send(JSON.stringify({name: taskName, description: taskDescription}));

        loadTasks();
    }

function loadTasks() {
  var xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function () {
      if (this.readyState == 4 && this.status == 200) {
          var tasks = JSON.parse(this.responseText);
          var html = '<tr>\n' +
              '        <th>id</th>\n' +
              '        <th>name</th>\n' +
              '        <th>Description</th>\n' +
              '        <th>Delete</th>\n' +
              '    </tr>';
          for (var i = 0; i < tasks.length; i++) {
              var task = tasks[i];
              console.log(task);
              html = html + '<tr><td>' + task.id + '</td>\n' +
                  '        <td>' + task.name + '</td>\n' +
                  '        <td>' + task.description + '</td>\n' +
                  '        <td><button onclick="deleteTask(' + task.id + ')">Delete</button></td></tr>';

          }
          document.getElementById("tasksList").innerHTML = html;
      }
  };
  xhttp.open("GET", "http://localhost:8080/tasks/findAll", true);
  xhttp.send();
}

loadTasks();