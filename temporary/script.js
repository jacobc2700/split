$(document).ready(function () {
  $('#req').click(function () {
    alert('click');
    $.ajax({
      url: 'http://localhost:8080/games',
      type: 'GET',
      crossDomain: true,
      async: false,
      contentType: 'application/json; charset=utf-8',
      dataType: 'json',
      jsonpCallback: 'myJsonMethod',
      success: function (json) {
        alert(json);
      },
      error: function (e) {
        console.log(e);
      },
    });
  });

  $('#req').click(function () {
    alert('click');
    $.ajax({
      url: 'http://localhost:8080/games',
      type: 'POST',
      crossDomain: true,
      async: false,
      contentType: 'application/json; charset=utf-8',
      dataType: 'json',
      jsonpCallback: 'myJsonMethod',
      success: function (json) {
        alert(json);
      },
      error: function (e) {
        console.log(e);
      },
    });
  });

  function getNewGameForm() {
    let gameName = $('#gameName').val();
    if (gameName == '')
      // check for spaces
      alert('no game name');
    // get playmer names... dynamically add textbox for players...
    // for now just split string
    let playerNames = $('#players').val();
    let players = playerNames.split(',');

    let gameForm = { gameName: gameName, playerNames: players };
    return JSON.stringify(gameForm);
  }

  function callback(response) {
    alert(response.id);
  }

  /* Create a new game */
  $('#createGame').click(function () {
    callAjax('http://localhost:8080/games', 'POST', getNewGameForm(), callback);
  });

  /* Make a request */
  /*
        url: localhost:8000/what
        type: GET, POST, etc.
        data: data that you need to pass to the call
        callback: function to run after request
    */
  function callAjax(url, type, data, callback) {
    $.ajax({
      url: url,
      type: type,
      crossDomain: true,
      contentType: 'application/json; charset=utf-8',
      dataType: 'json',
      data: data, //Postman body: what data to pass to the call.
      jsonp: false,
      success: function (json) {
        callback(json);
      },
      error: function (e) {
        console.log('Error making ajax call: ' + e);
      },
    });
  }
});
