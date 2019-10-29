<template>
  <div>
    <div>
      <button @click="go">nihao</button>
      <div id="anchor">
        <img
          src="https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg"
          alt="示例锚点"
          style="width:100px; height:100px;"
        />
      </div>
    </div>
    <div id="map" class="map"></div>
    <div id="popup" class="ol-popup">
      <a href="#" id="popup-closer" class="ol-popup-closer"></a>
      <div id="popup-content"></div>
    </div>
  </div>
</template>

<script>
import ol from "openlayers";

// import OlFeature from "ol/Feature";
// import OlGeomPoint from "ol/geom/Point";
// import OlLayerVector from "ol/layer/Vector";
// import OlSourceVector from "ol/source/Vector";
// import OlStyleStyle from "ol/style/Style";
// import OlStyleIcon from "ol/style/Icon";

export default {
  name: "TestOL",
  data() {
    return {
      // map: "",
      hitTolerance: ""
    };
  },
  methods: {
    go() {
      // this.$router.push("/skip");
      this.$router.push("/PointOvelay");
    },
    // // 方法一
    // // 添加图标的方法
    // addIconMarker(map) {
    //   var startMarker = new ol.Feature({
    //     type: "icon",
    //     geometry: new ol.geom.Point([113.016555, 22.985555])
    //   });

    //   var vectorLayer = new ol.layer.Vector({
    //     source: new ol.source.Vector({
    //       features: [startMarker]
    //     }),
    //     style: new ol.style.Style({
    //       image: new ol.style.Icon({
    //         anchor: [0.5, 1],
    //         src:
    //           "https://fuss10.elemecdn.com/e/5d/4a731a90594a4af544c0c25941171jpeg.jpeg"
    //         // window.location.origin +
    //         // window.location.pathname +
    //         // "static/mapMoniter/0.png"
    //         // src: http://192.168.4.61:9527/static/mapMoniter/0.png
    //         // 说明下，因为vue项目打包之后，我这张图片放到了static目录下，直接给相对路径是无法访问到，
    //         // 可以通过js原生的API拿到对应的前台服务器ip和端口，还有项目名称，就可以访问到，下面附了对应帖子链接
    //       }),
    //       // 设置图片下面显示字体的样式和内容
    //       text: new Text({
    //         text: "文字描述", // 添加文字描述
    //         font: "14px font-size", // 设置字体大小
    //         fill: new ol.style.Fill({
    //           // 设置字体颜色
    //           color: "#1CAF9A"
    //         }),
    //         offsetY: 10 // 设置文字偏移量
    //       })
    //     })
    //   });
    //   map.addLayer(vectorLayer);
    // },
    // // 方法二
    // addOverlay(map, e) {
    //   // 下面把上面的图标附加到地图上，需要一个ol.Overlay
    //   var anchor = new ol.Overlay({
    //     element: document.getElementById("anchor")
    //   });

    //   console.log(e.coordinate);
    //   if (map.hasFeatureAtPixel(e.pixel)) {
    //     var feature = map.getFeaturesAtPixel(e.pixel);
    //   }

    //   // 关键的一点，需要设置附加到地图上的位置
    //   // anchor.setPosition([113.016555, 22.985555]);
    //   anchor.setPosition(e.coordinate);
    //   // 然后添加到map上
    //   map.addOverlay(anchor);
    // },

    // 方法三
    //增加坐标点
    AddPoint(layer, e) {
      //设置位置坐标
      //经纬度转坐标
      var point = e.coordinate;

      //如果类型是矢量标注则添加矢量标签，否则添加覆盖标签
      this.addVectorLabel("FoShanLabel", point, layer);
    },

    //添加矢量标签
    addVectorLabel(title, coordinate, layer) {
      //初始化一个新的点要素
      var newFeature = new ol.Feature({
        geometry: new ol.geom.Point(coordinate),
        name: title
      });
      //设置点的样式
      newFeature.setStyle(this.createLabelStyle(newFeature));

      //清楚坐标点
      // layer.getSource().clear();

      //将当前要素添加到矢量数据源中
      layer.getSource().addFeature(newFeature);
    },

    //创建样式
    createLabelStyle(feature) {
      //返回一个样式
      return new ol.style.Style({
        //把点的样式换成ICON图标
        image: new ol.style.Icon({
          //设置图标偏移
          anchor: [0.5, 1],
          //标注样式的起点位置
          anchorOrigin: "top-right",
          //X方向单位：分数
          anchorXUnits: "fraction",
          //Y方向单位：像素
          anchorYUnits: "pixels",
          //偏移起点位置的方向
          offsetOrigin: "top-right",
          //透明度
          opacity: 0.9,
          //图片路径
          //src: 'images/map.png'
          src: "https://webapi.amap.com/theme/v1.3/markers/n/mark_b.png"
        }),
        //文本样式
        text: new ol.style.Text({
          //对齐方式
          textAlign: "center",
          //文本基线
          textBaseline: "middle",
          //字体样式
          font: "normal 14px 微软雅黑",
          //文本内容
          //text: feature.get('name'),
          text: "",
          //填充样式
          fill: new ol.style.Fill({
            color: "#aa3300"
          }),
          //笔触
          stroke: new ol.style.Stroke({
            color: "#ffcc33",
            width: 2
          })
        }),
        //层
        zIndex: 20
      });
    },

    // 删除标注方法
    deletePoint(layer, e) {
      //设置位置坐标
      //经纬度转坐标
      var point = e.coordinate;

      //如果类型是矢量标注则添加矢量标签，否则添加覆盖标签
      this.deleteVectorLabel("", point, layer);
    },
    deleteVectorLabel(title, coordinate, layer) {
      markVectorSource.removeFeature(iconFeature);
    }
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
      //设置弹出框的容器
      element: container,
      //是否自动平移，即假如标记在屏幕边缘，弹出时自动平移地图使弹出框完全可见
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

    var modify = new ol.interaction.Modify({ source: new ol.source.Vector() });
    map.addInteraction(modify);

    var draw, snap; // global so we can remove them later
    // var typeSelect = document.getElementById("type");

    function addInteractions() {
      draw = new ol.interaction.Draw({
        source: ol.source.Vector(),
        type: "Point"
      });
      map.addInteraction(draw);
      snap = new ol.interaction.Snap({ source: ol.source.Vector() });
      map.addInteraction(snap);
    }

    addInteractions();

    // click事件
    // var _this = this;
    // map.on("click", function(e) {
    //   var hit = false;
    //   var labelHit = false;
    //   map.forEachFeatureAtPixel(
    //     e.pixel,
    //     function(val) {
    //       if (val.get("name") == "FoShanPoint") {
    //         hit = true;
    //       } else if (val.get("name") == "FoShanLabel") {
    //         labelHit = true;
    //       }
    //     },
    //     {
    //       hitTolerance: this.hitTolerance
    //     }
    //   );
    //   if (labelHit) {
    //     console.log("labelHit");
    //   } else if (hit) {
    //     // _this.addIconMarker(map);
    //     // _this.addOverlay(map, e);
    //     // _this.AddPoint(circleLayer, e);

    //     // pointOne.getStyle().setFill("green");
    //     console.log("hit");
    //     // alert("hit");
    //     // 获取当前点击坐标，并设置到HTML元素上去

    //     var coordinate = e.coordinate;

    //     content.innerHTML =
    //       "<div><div><div><div>你好</div><div>你好</div></div><hr><div><div>测试内容</div><div>测试内容</div></div></div><div>nihao </div></div>";
    //     _this.$nextTick(() => {
    //       overlay.setPosition(coordinate);
    //     });

    //     // 设置overlay的位置，从而显示在鼠标点击处
    //   } else {
    //     _this.AddPoint(circleLayer, e);
    //     // pointOne.getStyle().setFill("black");
    //     console.log("no hit");
    //     _this.AddPoint(circleLayer, e);
    //   }
    //   // point.changed();
    // });

    // 监听singleclick事件,通过点击事件，获取对应点的feature图标
    // map.on("singleclick", function(e) {
    //   console.log(e.coordinate);
    //   if (map.hasFeatureAtPixel(e.pixel)) {
    //     var feature = map.getFeaturesAtPixel(e.pixel);
    //   }
    // });
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