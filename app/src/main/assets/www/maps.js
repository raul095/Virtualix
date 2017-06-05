function myMap() {
          var mapCanvas = document.getElementById("map");
          var mapOptions = {
            center: new google.maps.LatLng(40.308743, -3.730483), zoom: 19
          };
          var map = new google.maps.Map(mapCanvas, mapOptions);
        }