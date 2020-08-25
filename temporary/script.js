//Global vars.
let gameID = '';
let players = '';
//write the constants for binary NUMBERS!

$(document).ready(function () {
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

  //Runs when a new game is created.
  function createGameCallback(response) {
    getAvailableActions(response.availableActions);

    //Display game and player info in divs.
    displayInfo(response);

    //Hide create new game button.
    $('#createGame').hide();
  }

  //Display game and player info.
  const displayInfo = (response) => {
    players = response.players;

    var playerInfoString = '';

    for (var i = 0; i < players.length; i++) {
      playerInfoString +=
        '<br/> Name: ' +
        response['PLAYER_' + players[i].id].name +
        '<br/> ID: ' +
        response['PLAYER_' + players[i].id].id +
        '<br/> Cards: ' +
        response['PLAYER_' + players[i].id].holdingCards.map((item) => {
          var str = [item.rank, item.suit].join(' ');
          return str;
        }) +
        '<br/> Matches: ' +
        response['PLAYER_' + players[i].id].matches +
        '<br/> Scoresheet: ' +
        response['PLAYER_' + players[i].id].scoreSheet +
        '<br/>------------------------------------------------------------------------------------------';
    }

    //Display game info.
    $('#listGameID').html(
      'Game ID: ' +
        response.id +
        '<br/>' +
        '<br/>' +
        'Status: ' +
        response.status +
        '<br/>' +
        '<br/>' +
        ' Number of Players: ' +
        response.players.length +
        '<br/>' +
        '<br/>' +
        ' Game Name: ' +
        response.name +
        '<br/>' +
        '<br/>' +
        'Current Card Index: ' +
        response.currentCardIndex +
        '<br/>' +
        '<br/>' +
        'Available Actions: ' +
        response.availableActions +
        '<br/>' +
        '<br/>' +
        'Player Turn ID: ' +
        response.playerTurn +
        '<br/>' +
        '<br/>'
    );

    $('#gamePlayers').html(playerInfoString);
  };

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
