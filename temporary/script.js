let gameID = '';
//write the constants for binary NUMBERS!

$(document).ready(function () {
  function gameIdCallback(response) {
    let longHTMLStr = '';

    for (var i = 0; i < response.length; i++) {
      longHTMLStr += '<p>' + response[i] + '</p>';
    }
    $('#listGameIDs').html(longHTMLStr);
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
    var playerStr = '';
    var playerInfoString = '';
    var players = response.players;

    for (var i = 0; i < players.length; i++) {
      playerInfoString +=
        '<br/> name: ' +
        response['PLAYER_' + players[i].id].name +
        '<br/> id: ' +
        response['PLAYER_' + players[i].id].id +
        '<br/> cards: ' +
        response['PLAYER_' + players[i].id].holdingCards.map((item) => {
          var str = [item.rank, item.suit].join(' ');
          return str;
        }) +
        '<br/> matches: ' +
        response['PLAYER_' + players[i].id].matches +
        '<br/> scoresheet: ' +
        response['PLAYER_' + players[i].id].scoreSheet;
      ('<br/>');
    }

    for (var i = 0; i < players.length; i++) {
      playerStr +=
        '<br/> name: ' +
        players[i].name +
        '<br/> id: ' +
        players[i].id +
        '<br/> card indexes: ' +
        players[i].holdingCardIndexes +
        '<br/>';
    }

    $('#listGameID').html(
      'Game ID:' +
        response.id +
        '<br/>' +
        '<br/>' +
        'Status: ' +
        response.status +
        '<br/>' +
        '<br/>' +
        ' how many players? ' +
        response.players.length +
        '<br/>' +
        '<br/>' +
        ' name of game:' +
        response.name +
        '<br/>' +
        '<br/>' +
        'current card index: ' +
        response.currentCardIndex +
        '<br/>' +
        '<br/>' +
        'available options: ' +
        response.availableActions +
        '<br/>' +
        '<br/>' +
        'Player turn: ' +
        response.playerTurn +
        '<br/>' +
        '<br/>' +
        'players: ' +
        playerInfoString +
        '<br />' +
        response.gameInfo.availableActions
    );
    getAvailableActions(response.availableActions);

    $('#createGame').hide();
  }

  function getAvailableActions(availableActionNumber) {
    if (availableActionNumber & 0b0000001) {
      console.log('Draw from discard pile.');
    }
    if (availableActionNumber & 0b0000010) {
      console.log('Draw from regular pile.');
    }
    if (availableActionNumber & 0b0000100) {
      console.log('Make a match w/2 cards.');
    }
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
