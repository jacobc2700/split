$(document).ready(function () {
  // Get all game IDs and display them in div tag
  function getGameIds() {
    callAjax('http://localhost:8080/games/ids', 'GET', null, gameIdCallback);
  }

  function gameIdCallback(response) {
    let longHTMLStr = '';

    for (var i = 0; i < response.length; i++) {
      //   $('#listGameIDs').append('<p>' + response[i] + '</p>');
      longHTMLStr += '<p>' + response[i] + '</p>';
    }
    // alert(type of response);
    $('#listGameIDs').html(longHTMLStr);
    // document.getElementById('listGameIDs').innerHTML = response;
  }

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

  /* Create a new game */
  $('#createGame').click(function () {
    callAjax(
      'http://localhost:8080/games',
      'POST',
      getNewGameForm(),
      createGameCallback
    );
  });

  function getNewGameForm() {
    let gameName = $('#gameName').val();
    let playerNames = $('#players').val();
    let players = playerNames.split(',');
    let gameForm = { gameName: gameName, playerNames: players };
    return JSON.stringify(gameForm);
  }

  function createGameCallback(response) {
    alert('Game ID: ' + response.id);
    getGameIds(response);
  }

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
