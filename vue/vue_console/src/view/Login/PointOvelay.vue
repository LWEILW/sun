<template>
  <div>
    <div id="map" class="map"></div>
    <div id="popup" class="ol-popup">
      <a href="#" id="popup-closer" class="ol-popup-closer"></a>
      <div id="popup-content"></div>
    </div>
  </div>
</template>

<script>
import ol from "openlayers";

export default {
  name: "TestOL",
  data() {
    return {
      map: "",
      hitTolerance: ""
    };
  },
  mounted: function() {
    /**
     * Elements that make up the popup.
     */
    var container = document.getElementById("popup");
    var content = document.getElementById("popup-content");
    var closer = document.getElementById("popup-closer");

    /**
     * Create an overlay to anchor the popup to the map.
     */
    var overlay = new ol.Overlay({
      element: container,
      autoPan: true,
      autoPanAnimation: {
        duration: 250
      }
    });

    /**
     * Add a click handler to hide the popup.
     * @return {boolean} Don't follow the href.
     */
    closer.onclick = function() {
      overlay.setPosition(undefined);
      closer.blur();
      return false;
    };

    var HOST = "http://localhost:8081";

    var osmLayer = new ol.layer.Tile({
      source: new ol.source.TileWMS({
        url: HOST + "/geoserver/Map/wms",
        params: {
          LAYERS: "Map:佛山地图",
          TILED: true //是否要将数据制作成切片，省略后返回的是一张完整图。
        },
        serverType: "geoserver",
        projection: "EPSG:4326"
      })
    });

    // 创建3个图层
    // var osmLayer = new ol.layer.Tile({
    //   source: new ol.source.CartoDB()
    // });

    var pointLayer = new ol.layer.Vector({
      source: new ol.source.Vector()
    });

    var circleLayer = new ol.layer.Vector({
      source: new ol.source.Vector()
    });

    // 创建地图
    var map = new ol.Map({
      layers: [osmLayer, pointLayer, circleLayer],
      overlays: [overlay],
      target: "map",
      view: new ol.View({
        center: [113.126425, 23.025729],
        // center: [113.15, 23.2564],
        projection: "EPSG:4326",
        zoom: 13,
        logo: "false"
      })
    });

    // 广佛点数组
    var GuangFoPointArr = [
      [113.146403, 22.964908],
      [113.135673, 22.971288],
      [113.121017, 22.970952],
      [113.113754, 22.989979],
      [113.115174, 22.999868],
      [113.115088, 23.012814],
      [113.114936, 23.024732],
      [113.118749, 23.032798],
      [113.12929, 23.033513],
      [113.139679, 23.033675],
      [113.147805, 23.037753],
      [113.160493, 23.04031],
      [113.161818, 23.049322],
      [113.161917, 23.061351],
      [113.164095, 23.072864]
    ];

    // 广佛车站数组
    var GuangFoStationArr = [
      "新城东站",
      "东平站",
      "世纪莲站",
      "澜石站",
      "魁奇站",
      "季华站",
      "同济站",
      "祖庙站",
      "普军北路站",
      "朝安站",
      "桂城站",
      "南桂路站",
      "镭岗站",
      "千灯湖站",
      "金融高新区站"
    ];

    // 佛山二号线'点'数组
    var FoShanPointArr = [
      [113.016393, 22.985415],
      [113.013576, 23.018104],
      [113.040187, 23.01544],
      [113.067499, 23.042863],
      [113.090841, 23.042779],
      [113.095998, 23.018413],
      [113.108948, 23.004305],
      [113.115178, 22.999866],
      [113.125148, 22.996614],
      [113.139525, 22.99784],
      [113.152195, 22.979064],
      [113.165112, 22.980462],
      [113.210262, 22.991049],
      [113.224937, 22.998372],
      [113.239027, 23.00569],
      [113.256278, 23.004475],
      [113.275824, 22.994826]
    ];

    // 佛山二号线'线'数组
    var FoShanStationArr = [
      "南庄站",
      "湖涌站",
      "绿岛湖",
      "莲塘站",
      "张槎站",
      "石湾站",
      "番村站",
      "魁奇路站",
      "石梁站",
      "湾华站",
      "登州站",
      "花卉世界站",
      "仙涌站",
      "石洲站",
      "林岳西站",
      "林岳东站",
      "广州南站"
    ];

    // 广佛线添加"点"至图层
    for (var i = 0; i < GuangFoPointArr.length; i++) {
      var poniter = new ol.geom.Point(GuangFoPointArr[i]);
      var point = new ol.Feature({
        geometry: poniter,
        name: "GuangFoPoint"
      });
      point.setStyle(
        new ol.style.Style({
          image: new ol.style.Circle({
            radius: 5,
            //矢量图层填充颜色，以及透明度
            fill: new ol.style.Fill({
              // color: "red"
              color: "red"
            }),
            //边界样式
            stroke: new ol.style.Stroke({
              color: "red",
              size: 2
            }),
            //文本样式
            text: new ol.style.Text({
              text: length.toString(),
              font: "12px Calibri,sans-serif",
              fill: new ol.style.Fill({
                color: "#000"
              }),
              stroke: new ol.style.Stroke({
                color: "#fff",
                width: 1
              })
            })
          }),
          text: new ol.style.Text({
            // font: '10px sans-serif' 默认这个字体，可以修改成其他的，格式和css的字体设置一样
            text: GuangFoStationArr[i],
            fill: new ol.style.Fill({
              color: "rgba(94,91,92,0.6)"
            }),
            offsetX: 25,
            offsetY: 10
          })
        })
      );

      // pointLayer.getSource().addFeature(point);
    }

    // 佛山二号线添加"点"至图层
    for (var i = 0; i < FoShanPointArr.length; i++) {
      var poniter = new ol.geom.Point(FoShanPointArr[i]);
      var point = new ol.Feature({
        geometry: poniter,
        name: "FoShanPoint"
      });

      point.setStyle(
        new ol.style.Style({
          image: new ol.style.Circle({
            radius: 5,
            //矢量图层填充颜色，以及透明度
            fill: new ol.style.Fill({
              color: "blue"
            }),
            //边界样式
            stroke: new ol.style.Stroke({
              color: "blue",
              size: 1
            }),
            //文本样式
            text: new ol.style.Text({
              text: length.toString(),
              font: "12px Calibri,sans-serif",
              fill: new ol.style.Fill({
                color: "#000"
              }),
              stroke: new ol.style.Stroke({
                color: "#fff",
                width: 3
              })
            })
          }),
          text: new ol.style.Text({
            // font: '10px sans-serif' 默认这个字体，可以修改成其他的，格式和css的字体设置一样
            text: FoShanStationArr[i],
            fill: new ol.style.Fill({
              color: "red"
            }),
            offsetX: 25,
            offsetY: 10
          })
        })
      );
      point.setId("point" + i);
      pointLayer.getSource().addFeature(point);
    }

    // 广佛线添加"线"至图层
    var GuangFoFeatureLine = new ol.geom.LineString(GuangFoPointArr);
    var GuangFoFeature = new ol.Feature({
      geometry: GuangFoFeatureLine
    });

    GuangFoFeature.setStyle(
      new ol.style.Style({
        stroke: new ol.style.Stroke({
          width: 2,
          color: "rgba(94,91,92,0.6)"
        })
      })
    );

    // circleLayer.getSource().addFeature(GuangFoFeature);

    // 佛山二号线添加"线"至图层
    var FoshanFeatureLine = new ol.geom.LineString(FoShanPointArr);
    var FoshanFeature = new ol.Feature({
      geometry: FoshanFeatureLine
    });

    FoshanFeature.setStyle(
      new ol.style.Style({
        stroke: new ol.style.Stroke({
          width: 2,
          color: "blue"
        })
      })
    );

    circleLayer.getSource().addFeature(FoshanFeature);

    // click事件
    var _this = this;
    map.on("click", function(e) {
      var hit = false;
      map.forEachFeatureAtPixel(
        e.pixel,
        function(val) {
          if (val.get("name") == "FoShanPoint") {
            hit = true;
          }
        },
        {
          hitTolerance: this.hitTolerance
        }
      );
      if (hit) {
        // pointOne.getStyle().setFill("green");
        // console.log("hit");
        // alert("hit");
        // 获取当前点击坐标，并设置到HTML元素上去

        var coordinate = e.coordinate;

        content.innerHTML =
          "<div><div><div><div>你好</div><div>你好</div></div><hr><div><div>测试内容</div><div>测试内容</div></div></div><div>nihao </div></div>";
        _this.$nextTick(() => {
          overlay.setPosition(coordinate);
        });

        // 设置overlay的位置，从而显示在鼠标点击处
      } else {
        // pointOne.getStyle().setFill("black");
        console.log("no hit");
      }
      // point.changed();
    });
  }
};
</script>

<style scoped>
#map {
  width: 1500px;
  height: 900px;
  border: 1px solid #ff0000;
}
.ol-popup {
  position: absolute;
  background-color: white;
  -webkit-filter: drop-shadow(0 1px 4px rgba(0, 0, 0, 0.2));
  filter: drop-shadow(0 1px 4px rgba(0, 0, 0, 0.2));
  padding: 15px;
  border-radius: 10px;
  border: 1px solid #cccccc;
  bottom: 12px;
  left: -50px;
  min-width: 280px;
}
.ol-popup:after,
.ol-popup:before {
  top: 100%;
  border: solid transparent;
  content: " ";
  height: 0;
  width: 0;
  position: absolute;
  pointer-events: none;
}
.ol-popup:after {
  border-top-color: white;
  border-width: 10px;
  left: 48px;
  margin-left: -10px;
}
.ol-popup:before {
  border-top-color: #cccccc;
  border-width: 11px;
  left: 48px;
  margin-left: -11px;
}
.ol-popup-closer {
  text-decoration: none;
  position: absolute;
  top: 2px;
  right: 8px;
}
.ol-popup-closer:after {
  content: "✖";
}
</style>