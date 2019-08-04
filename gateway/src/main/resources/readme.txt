routes:
    adder: 
      path: /one/**
    sub: 
      path: /two/**
      
Requests for url /one/** 
will be forwarded to the adder service
at /** url i.e. if a request url is /one/add/5/6 it will be 
forwared to /add/5/6 on adder service.

Requests for url /two/** 
will be forwarded to the sub service
at /** url.

If the prefix one/two are not be removed then
stripPrefix: false need to additionally used with paths.




      