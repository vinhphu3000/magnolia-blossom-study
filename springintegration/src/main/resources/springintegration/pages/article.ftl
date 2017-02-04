<html>
<head>
    <link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.1/css/bootstrap-combined.min.css" rel="stylesheet">
    [@cms.init /]
</head>
<body>
    <div class="container">
        <div class="hero-unit">
            <h1>Article ${content.topic!}</h1>
            ${cmsfn.decode(content).text!}
        </div>
        <div class="row">
            <div class="span8">
                [@cms.area name="main"/]
            </div>
            <div class="span4">
                [@cms.area name="promos"/]
            </div>
        </div>
    </div>
</body>
</html>