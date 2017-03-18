<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${SITE_NAME} - ${SITE_SEO_TITLE} - Powered By JEESNS</title>
    <meta name="keywords" content="${SITE_KEYS}"/>
    <meta name="description" content="${SITE_DESCRIPTION}"/>
    <meta name="author" content="JEESNS"/>
    <link href="${base}/res/common/css/bootstrap.min.css" rel="stylesheet">
    <link href="${base}/res/common/css/font-awesome.min.css" rel="stylesheet">
    <link rel="stylesheet" href="${base}/res/common/css/jeesns.css">
    <link rel="stylesheet" href="${base}/res/common/css/jeesns-skin.css">
    <link href="${base}/res/plugins/emoji/css/emoji.css" rel="stylesheet">
    <!--[if lt IE 9]>
    <script src="${base}/res/common/js/html5shiv.min.js"></script>
    <script src="${base}/res/common/js/respond.min.js"></script>
    <![endif]-->
    <script src="${base}/res/common/js/jquery-2.1.1.min.js"></script>
    <script src="${base}/res/common/js/bootstrap.min.js"></script>
    <script src="${base}/res/plugins/layer/layer.js"></script>
    <script src="${base}/res/common/js/jquery.form.js"></script>
    <script src="${base}/res/common/js/jeesns.js"></script>
    <script src="${base}/res/common/js/extendPagination.js"></script>
    <script src="${base}/res/modules/weibo.js"></script>
    <script src="${base}/res/plugins/emoji/js/underscore-min.js"></script>
    <script src="${base}/res/plugins/emoji/js/editor.js"></script>
    <script src="${base}/res/plugins/emoji/js/emojis.js"></script>
</head>

<body class="gray-bg">
<#include "/index/common/header.ftl"/>
<div class="wrapper wrapper-content blog">
    <div class="container">
        <div class="row">
<#list getItemsList as items>
  <div class="col-sm-6 col-md-4 col-lg-3 ">
          <div class="thumbnail">
            <a href="${items.item_url}" title="${items.nick}" target="_blank" onclick="_hmt.push(['_trackEvent', 'tile', 'click', 'Yarn'])"><img class="lazy" src="${items.pict_url}" width="300" height="150" data-src="${items.pict_url}" alt="Yarn 中文文档"></a>
            <div class="caption">
              <h3>
                <a href="${items.item_url}" title="${items.nick}" target="_blank" onclick="_hmt.push(['_trackEvent', 'tile', 'click', 'Yarn'])">${items.zk_final_price}<small>｜${items.reserve_price}｜${items.provcity}｜销量：${items.user_type}</small></a>
              </h3>
              <p>
             ${items.title}
              </p>
              <p> 
        <#assign imagesMap=items.small_images/> 
		<#assign  keys=imagesMap?keys/>
		<#list keys as key>
                    <#list imagesMap["${key}"] as node>
					<img class="lazy" src="${node}" width="60" height="60" data-src="${node}" alt="${items.title}">
					</#list>
		</#list></p>
		<p style="display:none"><span>${items.num_iid}</span><span>${items.seller_id}</span><span>${items.volume}</span></p>
            </div>
          </div>
        </div>
      




				</#list>


        </div>
    </div>
</div>
<#include "/index/common/footer.ftl"/>
<script type="text/javascript">
    $(function () {
        $(".pagination").jeesns_page("jeesnsPageForm");
        $(".weibo-favor").click(function () {
            weibo.favor($(this), "${base}")
        });
        $('#emoji').emoji({
            insertAfter: function (item) {
                $('#weibo-content').insertContent(':' + item.name + ':')
            }
        }, "${base}");
    });
</script>
</body>
</html>