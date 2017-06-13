/*global Qiniu */
/*global plupload */
/*global FileProgress */
/*global hljs */


$(function () {
    var uploader = Qiniu.uploader({
        runtimes: 'html5,flash,html4',
        browse_button: 'pickfiles',
        container: 'container',
        drop_element: 'container',
        max_file_size: '1000mb',
        flash_swf_url: 'bower_components/plupload/js/Moxie.swf',
        dragdrop: true,
        chunk_size: '4mb',
        multi_selection: true,
        uptoken_url: $('#uptoken_url').val(),
        // uptoken_func: function(){
        //     var ajax = new XMLHttpRequest();
        //     ajax.open('GET', $('#uptoken_url').val(), false);
        //     ajax.setRequestHeader("If-Modified-Since", "0");
        //     ajax.send();
        //     if (ajax.status === 200) {
        //         var res = JSON.parse(ajax.responseText);
        //         console.log('custom uptoken_func:' + res.uptoken);
        //         return res.uptoken;
        //     } else {
        //         console.log('custom uptoken_func err');
        //         return '';
        //     }
        // },
        domain: $('#domain').val(),
        get_new_uptoken: false,
        filters: {
            max_file_size: '1000mb',
            prevent_duplicates: true,
            mime_types: [
                {title: "Video files", extensions: "flv,mpg,mpeg,avi,wmv,mov,asf,rm,rmvb,mkv,m4v,mp4"} // 限定flv,mpg,mpeg,avi,wmv,mov,asf,rm,rmvb,mkv,m4v,mp4后缀格式上传
            ]
        },
        // downtoken_url: '/downtoken',
        unique_names: false,
        save_key: false,
        // x_vars: {
        //     'id': '1234',
        //     'time': function(up, file) {
        //         var time = (new Date()).getTime();
        //         // do something with 'time'
        //         return time;
        //     },
        // },
        auto_start: true,
        log_level: 5,
        init: {
            'FilesAdded': function (up, files) {
                $('table').show();
                $('#success').hide();
                plupload.each(files, function (file) {
                    var progress = new FileProgress(file, 'fsUploadProgress');
                    progress.setStatus("等待...");
                    progress.bindUploadCancel(up);
                });
            },
            'BeforeUpload': function (up, file) {
                $("#pickfiles").attr("disabled", "disabled");
                $("#voName").attr("disabled", "disabled");
                if ($("#course").val() != 1) {
                    $("#pKind").attr("disabled", "disabled");
                    $("#cKind").attr("disabled", "disabled");
                } else {
                    $("#kind").attr("disabled", "disabled");
                    $("#month").attr("disabled", "disabled");
                    $("#age").attr("disabled", "disabled");
                    $("#stepImg").attr("disabled", "disabled");
                }
                var progress = new FileProgress(file, 'fsUploadProgress');
                var chunk_size = plupload.parseSize(this.getOption('chunk_size'));
                if (up.runtime === 'html5' && chunk_size) {
                    progress.setChunkProgess(chunk_size);
                }
            },
            'UploadProgress': function (up, file) {
                var progress = new FileProgress(file, 'fsUploadProgress');
                var chunk_size = plupload.parseSize(this.getOption('chunk_size'));
                progress.setProgress(file.percent + "%", file.speed, chunk_size);
            },
            'UploadComplete': function () {
                $('#success').show();
                $("#voName").attr("disabled", false);
                if ($("#course").val() != 1) {
                    $("#pKind").attr("disabled", false);
                    $("#cKind").attr("disabled", false);
                } else {
                    $("#kind").attr("disabled", false);
                    $("#month").attr("disabled", false);
                    $("#age").attr("disabled", false);
                    $("#stepImg").attr("disabled", false);
                }
            },
            'FileUploaded': function (up, file, info) {
                var progress = new FileProgress(file, 'fsUploadProgress');
                progress.setComplete(up, info.response);
                var domain = up.getOption('domain');
                var res = $.parseJSON(info.response);
                var url = domain + res.key;
                $("#vourl").val(url);
                $.ajax({
                    url: url + "?avinfo",
                    type: "post",
                    async: false,
                    success: function (data) {
                        $("#voduration").val(data.format.duration);
                    }
                });
                if ($("#course").val() != 1) {
                    var pi = {
                        voname: $("#voName").val().toString().trim(),
                        fkind: $("#pKind").val().toString(),
                        skind: $("#cKind").val().toString(),
                        vourl: $("#vourl").val().toString(),
                        voduration: Math.round($("#voduration").val())
                    };
                    $.ajax({
                        url: "/root/uploadVideoAjax",
                        data: JSON.stringify(pi),
                        contentType: 'application/json;charset=utf-8',
                        type: "post",
                        async: false,
                        success: function (data) {
                            if (data == 1) {
                                //alert("上传成功");
                                //window.location.reload();
                            }
                        }
                    });
                } else {
                    var pi2 = {
                        voname: $("#voName").val().toString().trim(),
                        kind: $("#kind").val().toString(),
                        month: $("#month").val().toString(),
                        age: $("#age").val().toString(),
                        vourl: $("#vourl").val().toString(),
                        voduration: Math.round($("#voduration").val()),
                        stepImg: $("#stepImg").val()
                    };
                    $.ajax({
                        url: "/root/uploadCourseVideoAjax",
                        data: JSON.stringify(pi2),
                        contentType: 'application/json;charset=utf-8',
                        type: "post",
                        async: false,
                        success: function (data) {
                            if (data == 1) {
                                alert("上传成功");
                                window.location.reload();
                            }
                        }
                    });
                }

            },
            'Error': function (up, err, errTip) {
                $('table').show();
                var progress = new FileProgress(err.file, 'fsUploadProgress');
                progress.setError();
                progress.setStatus(errTip);
            }
            ,
            'Key': function (up, file) {
                if ($("#course").val() != 1) {
                    var select = document.getElementById("pKind");
                    var options = select.options;
                    var index = select.selectedIndex;
                    var selectedText = options[index].text;
                    var select2 = document.getElementById("cKind");
                    var options2 = select2.options;
                    var index2 = select2.selectedIndex;
                    var selectedText2 = options2[index2].text;
                    var folder = selectedText + '/' + selectedText2 + '/';
                    return folder + file.name;
                } else {
                    var select1 = document.getElementById("kind");
                    var options1 = select1.options;
                    var index1 = select1.selectedIndex;
                    var selectedText1 = options1[index1].text;
                    var select22 = document.getElementById("age");
                    var options22 = select22.options;
                    var index22 = select22.selectedIndex;
                    var selectedText22 = options22[index22].text;
                    var select3 = document.getElementById("month");
                    var options3 = select3.options;
                    var index3 = select3.selectedIndex;
                    var selectedText3 = options3[index3].text;
                    var folder1 = selectedText1 + '/' + selectedText22 + '/' + selectedText3 + '/';
                    return folder1 + file.name;
                }
            }
        }
    });

    uploader.bind('FileUploaded', function () {
        console.log('hello man,a file is uploaded');
    });
    $('#container').on(
        'dragenter',
        function (e) {
            e.preventDefault();
            $('#container').addClass('draging');
            e.stopPropagation();
        }
    ).on('drop', function (e) {
        e.preventDefault();
        $('#container').removeClass('draging');
        e.stopPropagation();
    }).on('dragleave', function (e) {
        e.preventDefault();
        $('#container').removeClass('draging');
        e.stopPropagation();
    }).on('dragover', function (e) {
        e.preventDefault();
        $('#container').addClass('draging');
        e.stopPropagation();
    });


    $('#show_code').on('click', function () {
        $('#myModal-code').modal();
        $('pre code').each(function (i, e) {
            hljs.highlightBlock(e);
        });
    });


    $('body').on('click', 'table button.btn', function () {
        $(this).parents('tr').next().toggle();
    });


    var getRotate = function (url) {
        if (!url) {
            return 0;
        }
        var arr = url.split('/');
        for (var i = 0, len = arr.length; i < len; i++) {
            if (arr[i] === 'rotate') {
                return parseInt(arr[i + 1], 10);
            }
        }
        return 0;
    };

    $('#myModal-img .modal-body-footer').find('a').on('click', function () {
        var img = $('#myModal-img').find('.modal-body img');
        var key = img.data('key');
        var oldUrl = img.attr('src');
        var originHeight = parseInt(img.data('h'), 10);
        var fopArr = [];
        var rotate = getRotate(oldUrl);
        if (!$(this).hasClass('no-disable-click')) {
            $(this).addClass('disabled').siblings().removeClass('disabled');
            if ($(this).data('imagemogr') !== 'no-rotate') {
                fopArr.push({
                    'fop': 'imageMogr2',
                    'auto-orient': true,
                    'strip': true,
                    'rotate': rotate,
                    'format': 'png'
                });
            }
        } else {
            $(this).siblings().removeClass('disabled');
            var imageMogr = $(this).data('imagemogr');
            if (imageMogr === 'left') {
                rotate = rotate - 90 < 0 ? rotate + 270 : rotate - 90;
            } else if (imageMogr === 'right') {
                rotate = rotate + 90 > 360 ? rotate - 270 : rotate + 90;
            }
            fopArr.push({
                'fop': 'imageMogr2',
                'auto-orient': true,
                'strip': true,
                'rotate': rotate,
                'format': 'png'
            });
        }

        $('#myModal-img .modal-body-footer').find('a.disabled').each(function () {

            var watermark = $(this).data('watermark');
            var imageView = $(this).data('imageview');
            var imageMogr = $(this).data('imagemogr');

            if (watermark) {
                fopArr.push({
                    fop: 'watermark',
                    mode: 1,
                    image: 'http://www.b1.qiniudn.com/images/logo-2.png',
                    dissolve: 100,
                    gravity: watermark,
                    dx: 100,
                    dy: 100
                });
            }

            if (imageView) {
                var height;
                switch (imageView) {
                    case 'large':
                        height = originHeight;
                        break;
                    case 'middle':
                        height = originHeight * 0.5;
                        break;
                    case 'small':
                        height = originHeight * 0.1;
                        break;
                    default:
                        height = originHeight;
                        break;
                }
                fopArr.push({
                    fop: 'imageView2',
                    mode: 3,
                    h: parseInt(height, 10),
                    q: 100,
                    format: 'png'
                });
            }

            if (imageMogr === 'no-rotate') {
                fopArr.push({
                    'fop': 'imageMogr2',
                    'auto-orient': true,
                    'strip': true,
                    'rotate': 0,
                    'format': 'png'
                });
            }
        });

        var newUrl = Qiniu.pipeline(fopArr, key);

        var newImg = new Image();
        img.attr('src', 'images/loading.gif');
        newImg.onload = function () {
            img.attr('src', newUrl);
            img.parent('a').attr('href', newUrl);
        };
        newImg.src = newUrl;
        return false;
    });

});
