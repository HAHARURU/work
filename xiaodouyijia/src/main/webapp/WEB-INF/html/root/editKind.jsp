<%--
  Created by IntelliJ IDEA.
  User: HARU
  Date: 2017/4/6
  Time: 8:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!--[if lt IE 7]><html class="no-js lt-ie9 lt-ie8 lt-ie7"><![endif]-->
<!--[if IE 7]><html class="no-js lt-ie9 lt-ie8"><![endif]-->
<!--[if IE 8]><html class="no-js lt-ie9"><![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js" lang="zh-CN"> <!--<![endif]-->
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <link rel="icon" href="${pageContext.request.contextPath}/resources/image/title_logo.png" type="image/x-icon"/>
    <title>小豆一家--Beans-park智能教育机器人,原创3~12岁分龄式STEM科学体系实验课程</title>
    <meta name="Keywords"
          content="小豆一家   Beanspark    stem  早教  教育品牌  教育机器人   智能机器人   手工 动手能力  诗歌  国学  服装设计   数学  物理   化学  生命科学  天文地理  趣味生活   场景教学  分龄课程  在线教育  亲子游  乐高  乐创  巧虎  鲨鱼公园 360机器人  学前教育   寓教于乐  小豆宝盒"/>
    <meta name="description"
          content="小豆一家推出国内首款智能早教机器人,针对4~12岁儿童对于事物的认知程度不同开发出美劳美艺、奇趣物化、玩转数理、生命科学、天文地理、趣味生活六大分龄课程体系,独创场景教学模式,还有小豆宝盒让儿童跟着手工视频一起做，让儿童在学习知识的同时也获得动手能力的提升。">
    <meta name="viewport" content="width=device-width">

    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/font-awesome.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/flat-ui.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/jquery.fullpage.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/buttons.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/sidebar.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/normalize.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/main2.css">
    <style type="text/css">
        .form-control, .select2-search input[type="text"] {
            border: 1px solid #34495e;
        }

        .error {
            color: red;
        }

        .select-success .select2-choice {
            background-color: #34495e;
        }

        .select-success .select2-choice:hover, .select-success .select2-choice.hover, .select-success .select2-choice:focus, .select-success .select2-choice:active {
            background-color: #A4C540;
            border-color: #A4C540;
        }

        .button-caution, .button-caution-flat {
            background-color: #34495e;
            border-color: #34495e;
        }

        .button-caution:hover, .button-caution:focus, .button-caution-flat:hover, .button-caution-flat:focus {
            background-color: #A4C540;
            border-color: #A4C540;
        }

        .table > tbody > tr > td, .table > tbody > tr > th, .table > tfoot > tr > td, .table > tfoot > tr > th, .table > thead > tr > td, .table > thead > tr > th {
            padding: 8px;
            line-height: 1.42857143;
            vertical-align: middle;
            border-top: 1px solid #ddd;
        }

        tr {
            vertical-align: middle;
        }

        td i {
            cursor: pointer;
            margin-left: 10px;
            margin-right: 10px;
        }

        .form-control[disabled], .form-control[readonly], fieldset[disabled] .form-control, .select2-search input[type="text"][disabled], .select2-search input[type="text"][readonly], fieldset[disabled] .select2-search input[type="text"] {
            color: black;
        }
    </style>

    <script src="${pageContext.request.contextPath}/resources/js/modernizr-2.6.2.min.js"></script>

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/html5shiv.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<%@include file="appbar.jsp" %>
<input type="hidden" id="domain" value="http://oqy6b34es.bkt.clouddn.com/">
<input type="hidden" id="uptoken_url" value="uptoken">
<div class="container-fluid">
    <div class="row">
        <%@include file="sidebar.jsp" %>
        <div class="main col-md-10 col-md-offset-2">
            <div class="page-header">
                <h2>修改种类</h2>
            </div>
            <div>
                <select class="select select-success select-block mbl" id="pKind-select"
                        onchange="return selectChange()">
                    <option value="-1">选择一级种类</option>
                    <c:forEach items="${fKind}" var="fks">
                        <option value="${fks.kid}">${fks.kname}</option>
                    </c:forEach>
                </select>
                <button id="add-button" class="pull-right button button-glow button-rounded button-caution"
                        onclick="addKind()">
                    添加二级种类
                </button>
                <div class="table-responsive">
                    <table class="table table-hover">
                        <tbody id="kindBody">
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content col-sm-12" style="padding-left: 0;padding-right: 0">
            <div class="modal-header col-sm-12" style="background-color: #34495e;color: #fff;">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                <h4 class="modal-title" id="modalLabel">添加二级种类</h4>
            </div>
            <div class="modal-body col-sm-12">
                <form class="form-horizontal col-sm-12" role="form" id="update_form">
                    <div class="form-group">
                        <label for="ckname" class="col-sm-3 control-label">二级种类：</label>
                        <div class="col-sm-9">
                            <input type="text" class="form-control" id="ckname" name="ckname">
                        </div>
                    </div>
                    <div class="col-md-12" style="margin-bottom: 10px">
                        <div id="container">
                            <button class="button button-caution btn-lg" id="pickfiles" href="#">
                                <i class="fa fa-plus"></i>
                                <span>选择图标</span>
                            </button>
                            <input type="hidden" id="iconImage" name="iconImage">
                        </div>
                    </div>
                    <div class="col-sm-6 col-sm-offset-3">
                        <div class="form-group pull-left">
                            <div class="col-sm-offset-3 col-sm-9">
                                <button type="button" class="btn btn-danger" data-dismiss="modal">
                                    取消
                                </button>
                            </div>
                        </div>
                        <div class="form-group pull-right">
                            <div class="col-sm-offset-3 col-sm-9">
                                <button type="submit" class="btn btn-success">
                                    提交
                                </button>
                            </div>
                        </div>
                    </div>
                </form>
                <div style="display:none" id="success" class="col-md-12">
                    <div class="alert-success">
                        上传成功！
                    </div>
                </div>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div>
<script src="${pageContext.request.contextPath}/resources/js/jquery.2.1.1.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.validate.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/messages_zh.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/plugins.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/bootstrap/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/jquery.fullpage.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/sidebar.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/flat-ui.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/moxie.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/plupload.dev.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/zh_CN.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/ui.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/qiniu.js"></script>

<script>
    var url;
    var k;
    var i;
    var im;
    $(function () {
        $("#pKind-select").val("-1");
        $("#editKind").addClass("active");
        $("select").select2({dropdownCssClass: 'dropdown-inverse'});

        $.validator.addMethod("containBlank",
                function (value, element, param) {
                    return value.indexOf(" ") == -1;
                },
                "不能包含空格"
        );
        $("#update_form").validate({
            ignore: [],
            rules: {
                ckname: {
                    required: true,
                    containBlank: "#ckname"
                },
                iconImage: {
                    required: true
                }
            },
            messages: {
                ckname: {
                    required: "必填",
                    containBlank: "不能包含空格"
                },
                iconImage: {
                    required: "必选"
                }
            },
            invalidHandler: function () {
                return false;
            },
            submitHandler: function () {
                var name = $("#ckname").val().toString().trim();
                var path = $("#iconImage").val();
                if (k == 0) {
                    var fkid = $("#pKind-select").val();
                    $.ajax({
                        url: "${pageContext.request.contextPath}/root/addKindAjax?fkid=" + fkid + "&ckname=" + name + "&icon=" + path,
                        type: "post",
                        success: function (data) {
                            var html = '<tr>' +//
                                    '<td class="col-sm-3">' +//
                                    '<input type="text" disabled="disabled" class="form-control " value="' + data.kname + '">' +//
                                    '</td>' +//
                                    '<td>' +//
                                    '<img class="img-responsive" src="' + data.iconimage + '">' +//
                                    '</td>' +//
                                    '<td>' +//
                                    '<i class="fa fa-edit" onclick="editItem(this,' + data.kid + ')"></i>' +//
                                    '<i class="fa fa-close"  onclick="deleteItem(this,' + data.kid + ')"></i>' +//
                                    '</td>' +//
                                    '</tr>';
                            $("#kindBody").append(html);
                            $('#myModal').modal('hide');
                        }
                    });
                } else {
                    $.ajax({
                        url: "${pageContext.request.contextPath}/root/editKindAjax?kid=" + k + "&ckname=" + name + "&icon=" + path,
                        type: "post",
                        success: function (data) {
                            if (data > 0) {
                                alert("编辑成功！");
                                $(i).val(name);
                                $(im).attr("src", path);
                                $('#myModal').modal('hide');
                            }
                        }
                    })
                }
                return false;//阻止表单提交
            }
        });

        var uploader = Qiniu.uploader({
            runtimes: 'html5,flash,html4',
            browse_button: 'pickfiles',
            container: 'container',
            drop_element: 'container',
            max_file_size: '100mb',
            flash_swf_url: 'bower_components/plupload/js/Moxie.swf',
            dragdrop: true,
            chunk_size: '4mb',
            multi_selection: false,
            uptoken_url: $('#uptoken_url').val(),
            domain: $('#domain').val(),
            get_new_uptoken: false,
            filters: {
                max_file_size: '100mb',
                prevent_duplicates: true,
                mime_types: [
                    {title: "Image files", extensions: "jpeg,jpg,gif,png"}
                ]
            },
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
                    $("#ckname").attr("disabled", "disabled");
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
                },
                'FileUploaded': function (up, file, info) {
                    var progress = new FileProgress(file, 'fsUploadProgress');
                    progress.setComplete(up, info.response);
                    $("#ckname").attr("disabled", false);
                    $("#pickfiles").attr("disabled", false);
                    var domain = up.getOption('domain');
                    var res = $.parseJSON(info.response);
                    url = domain + res.key;
                    $("#iconImage").val(url);
                },
                'Error': function (up, err, errTip) {
                    $('table').show();
                    var progress = new FileProgress(err.file, 'fsUploadProgress');
                    progress.setError();
                    progress.setStatus(errTip);
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

    function selectChange() {
        var fkid = $("#pKind-select").val();
        $.ajax({
            url: "${pageContext.request.contextPath}/root/changeKindAjax?fkid=" + fkid,
            type: "post",
            success: function (data) {
                $("tbody").empty();
                $.each(data, function (index, kl) {
                    var html = '<tr>' +//
                            '<td class="col-sm-3">' +//
                            '<input type="text" disabled="disabled" class="form-control " value="' + kl.kname + '">' +//
                            '</td>' +//
                            '<td>' +//
                            '<img class="img-responsive" src="' + kl.iconimage + '">' +//
                            '</td>' +//
                            '<td>' +//
                            '<i class="fa fa-edit" onclick="editItem(this,' + kl.kid + ')"></i>' +//
                            '<i class="fa fa-close"  onclick="deleteItem(this,' + kl.kid + ')"></i>' +//
                            '</td>' +//
                            '</tr>';
                    $("#kindBody").append(html);
                })
            }
        })
    }
    function addKind() {
        if ($("#pKind-select").val() != -1) {
            k = 0;
            $("#ckname").val("");
            $("#iconImage").val("");
            $("#success").css("display","none");
            $('#myModal').modal('show');
        }
    }

    function deleteItem(vthis, kid) {
        $.ajax({
            url: "${pageContext.request.contextPath}/root/deleteKindAjax?kid=" + kid,
            type: "post",
            success: function (data) {
                if (data > 0) {
                    $(vthis).parents("tr").remove();
                }
            }
        })
    }

    function editItem(vthis, kid) {
        $('#myModal').modal('show');
        k = kid;
        i = $(vthis).parents("tr").find("input");
        im = $(vthis).parents("tr").find("img");
        $("#ckname").val($(vthis).parents("tr").find("input").val());
        $("#iconImage").val($(vthis).parents("tr").find("img").attr("src"));
    }

</script>
</body>
</html>

