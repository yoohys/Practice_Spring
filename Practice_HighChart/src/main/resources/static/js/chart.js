$(function () {
    chart = new Highcharts.chart('container', {
        chart: {

            type: 'area',
            animation: Highcharts.svg,
            marginRight: 10,
            backgroundColor: {
                linearGradient: [0, 0, 500, 500],
                stops: [
                    [0, 'rgb(255, 255, 255)'],
                    [1, 'rgb(200, 200, 2000)']
                ]
            }, plotBackgroundColor: 'rgba(255, 255, 255, .9)',
            plotShadow: true,
            plotBorderWidth: 1,
            events: { // 차트 이벤트
                load: function () {
                    var series = this.series[0]; // Series의 index 0을 대입
                    var series2 = this.series[1]; // Series의 index 0을 대입
                    var series3 = this.series[2]; // Series의 index 0을 대입

                    setInterval(function () {
                        x = (new Date()).getTime(); // 현재 시간
                        z = Math.random() * 100;
                        z1 = Math.random() * 100;
                        z2 = Math.random() * 100;


                        series.addPoint([x, z], false, true);
                        series2.addPoint([x, z1], false, true);
                        series3.addPoint([x, z2], true, true);

                    }, 1000); // interval end
                } // load end
            }
        },
        time: {
            useUTC: false
        },
        title: {
            text: '하이차트 연습'
        },
        subtitle: {
            text: 'Random의 수를 동적으로 생성하는 HighChart 연습'
        },
        xAxis: {
            title: {
                text: '시간'
            },
            type: "datetime"
        },
        yAxis: {
            min: 0,
            max: 100,
            title: {
                text: '랜덤 숫자'
            }
        },
        plotOptions: {
            series: {
                marker: {
                    enabled: false
                }
            }
        },
        series: [{
            color: 'red',
            name: '랜덤개수',
            data: (function () {
                // generate an array of random data
                var data = [],
                    time = (new Date()).getTime(),
                    i;

                for (i = -19; i <= 0; i += 1) {
                    data.push({
                        x: time + i * 1000,
                        z: Math.random() * 100
                    });
                }
                return data;
            }())
        }, {
            color: 'orange',
            name: '랜덤개수1',
            data: (function () {
                // generate an array of random data
                var data = [],
                    time = (new Date()).getTime(),
                    i;

                for (i = -19; i <= 0; i += 1) {
                    data.push({
                        x: time + i * 1000,
                        z1: Math.random() * 100
                    });
                }
                return data;
            }())
        }, {
            color: 'yellow',
            name: '랜덤개수2',
            data: (function () {
                // generate an array of random data
                var data = [],
                    time = (new Date()).getTime(),
                    i;

                for (i = -19; i <= 0; i += 1) {
                    data.push({
                        x: time + i * 1000,
                        z2: Math.random() * 100
                    });
                }
                return data;
            }())
        }],
        tooltip: {valueSuffix: '개'},
        credits: {
            enabled: false
        },
        exporting: {enabled: false}
    });

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    chart = new Highcharts.chart('container2', {
        chart: {
            type: 'area',
            animation: Highcharts.svg,
            marginRight: 10,
            backgroundColor: {
                linearGradient: [0, 0, 500, 500],
                stops: [
                    [0, 'rgb(255, 255, 255)'],
                    [1, 'rgb(200, 200, 2000)']
                ]
            }, plotBackgroundColor: 'rgba(255, 255, 255, .9)',
            plotShadow: true,
            plotBorderWidth: 1,
            events: { // 차트 이벤트
                load: function () {
                    var series = this.series[0]; // Series의 index 0을 대입
                    var series2 = this.series[1]; // Series의 index 0을 대입
                    var series3 = this.series[2]; // Series의 index 0을 대입

                    setInterval(function () {
                        x = (new Date()).getTime(); // 현재 시간
                        z = Math.random() * 100;
                        z1 = Math.random() * 100;
                        z2 = Math.random() * 100;


                        series.addPoint([x, z], false, true);
                        series2.addPoint([x, z1], false, true);
                        series3.addPoint([x, z2], true, true);

                    }, 1000); // interval end
                } // load end
            }
        },
        time: {
            useUTC: false
        },
        title: {
            text: '하이차트 연습2'
        },
        subtitle: {
            text: 'Random의 수를 동적으로 생성하는 HighChart 연습'
        },
        xAxis: {
            title: {
                text: '시간'
            },
            type: "datetime"
        },
        yAxis: {
            min: 0,
            max: 100,
            title: {
                text: '랜덤 숫자'
            }
        },
        plotOptions: {
            series: {
                marker: {
                    enabled: false
                }
            }
        },
        series: [{
            color: 'blue',
            name: '랜덤개수',
            data: (function () {
                // generate an array of random data
                var data = [],
                    time = (new Date()).getTime(),
                    i;

                for (i = -19; i <= 0; i += 1) {
                    data.push({
                        x: time + i * 1000,
                        z: Math.random() * 100
                    });
                }
                return data;
            }())
        }, {
            color: 'green',
            name: '랜덤개수1',
            data: (function () {
                // generate an array of random data
                var data = [],
                    time = (new Date()).getTime(),
                    i;

                for (i = -19; i <= 0; i += 1) {
                    data.push({
                        x: time + i * 1000,
                        z1: Math.random() * 100
                    });
                }
                return data;
            }())
        }, {
            color: 'purple',
            name: '랜덤개수2',
            data: (function () {
                // generate an array of random data
                var data = [],
                    time = (new Date()).getTime(),
                    i;

                for (i = -19; i <= 0; i += 1) {
                    data.push({
                        x: time + i * 1000,
                        z2: Math.random() * 100
                    });
                }
                return data;
            }())
        }],
        tooltip: {valueSuffix: '개'},
        credits: {
            enabled: false
        },
        exporting: {enabled: false}
    });

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    data = {
        datasets: [{
            backgroundColor: ['red', 'yellow', 'blue'],
            data: [10, 20, 30]
        }],
        // 라벨의 이름이 툴팁처럼 마우스가 근처에 오면 나타남
        labels: ['red', 'yellow', 'blue']
    };

    chart = new Highcharts.chart('container3', {
        chart: {
            animation: Highcharts.svg,
            marginRight: 10,
            backgroundColor: {
                linearGradient: [0, 0, 500, 500],
                stops: [
                    [0, 'rgb(255, 255, 255)'],
                    [1, 'rgb(200, 200, 2000)']
                ]
            }, plotBackgroundColor: 'rgba(255, 255, 255, .9)',
            // events: { // 차트 이벤트
            //     load: function () {
            //         var series = this.series[0]; // Series의 index 0을 대입
            //         var series2 = this.series[1]; // Series의 index 0을 대입
            //         var series3 = this.series[2]; // Series의 index 0을 대입
            //
            //         setInterval(function () {
            //             x = (new Date()).getTime(); // 현재 시간
            //             z = Math.random() * 10 + 30;
            //             z1 = Math.random() * 10 + 30;
            //             z2 = 100 - z - z1;
            //
            //
            //             series.addPoint([x, z], false, true);
            //             series2.addPoint([x, z1], false, true);
            //             series3.addPoint([x, z2], true, true);
            //             console.log("z Data insert : " + z);
            //             console.log("z1 Data insert : " + z1);
            //             console.log("z2 Data insert : " + z2);
            //
            //         }, 1000); // interval end
            //     } // load end
            // }
        },
        title: {
            text: '파이차트 연습'
        },
        subtitle: {
            text: 'Random의 수를 동적으로 생성하는 HighChart 연습'
        },
        plotOptions: {
            series: {
                marker: {
                    enabled: false
                }
            }
        },
        series: [{
            type: 'pie',
            name: '랜덤비교표',
            data: [
                ['랜덤 데이터1', Math.round(Math.random() * 10, 3) + 30],
                ['랜덤 데이터1', Math.round(Math.random() * 10, 3) + 20],
                ['랜덤 데이터1', Math.round(Math.random() * 10, 3) + 10]
            ]
        }],
        tooltip: {
            valueSuffix: '%'
        }
        ,
        credits: {
            enabled: false
        }
        ,
        exporting: {
            enabled: false
        }
    });
})
;