[#import "/org/springframework/web/servlet/view/freemarker/spring.ftl" as spring /]
[#assign htmlEscape=true in spring /]
[#assign blossom=JspTaglibs["blossom-taglib"] /]

<h2>Subscribe to our newsletter!</h2>
<form action="?" method="POST">
   [@blossom.pecidInput /]
   E-mail<br/>
   [@spring.formInput path="newsletterForm.email" attributes='class="textinput"' /]&nbsp;[@spring.showErrors separator=", " classOrStyle="errorMessage" /]<br/>
   <input type="submit" class="btn btn-large btn-primary" value="Subscribe" />
</form>