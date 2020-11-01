//开发权限控制自定义指令
Vue.directive('has', {
    inserted: function (el, binding, vnode) {
        //功能
        //console.log(el); //设置指令的DOM元素对象
        //console.log(binding); // 绑定对象
        console.log(binding.value); //指令传递的值
        //用户分配的按钮资源---从sessionStorage获取btnList
        //var
        //btnList = 'user:add,user:edit,user:delete,role:add,resource:add';
        var btnList = sessionStorage.getItem("butList");
        //应用
        //判断按钮传递的值 binding.value 是否在btnList 存在
        if (btnList.indexOf(binding.value) == -1) {
            console.log(binding.value + "按钮不存在");
            //将按钮删除 DOM编程 删除DOM节点 父节点.removeChild(子节点)
            el.parentNode.removeChild(el);
        } else {
            console.log(binding.value + "按钮存在");
        }
    }
})
;