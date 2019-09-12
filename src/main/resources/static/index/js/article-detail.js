$(function () {
    border_change($(".at-sort-comment-a"), 6);
});

let r_vditor;

//显示-隐藏回复框
function show_reply(obj) {
    let display = $(obj).parents('.comment-box').find('.reply-holder').css('display');
    if (display === 'none') {
        $(obj).parents('.comment-box').find('.reply-btn').before(
            '<div id="reply-vditor" class="reply-text-area"></div>'
        );
        r_vditor = init_reply_vditor();
        $(obj).parents('.comment-box').find('.reply-holder').slideDown();
        let user_name = $(obj).parents('.comment-box').find('.user-name').text();
        r_vditor.setValue("@" + user_name + ":");
    } else {
        $(obj).parents('.comment-box').find('.reply-holder').slideUp();
        $(obj).parents('.comment-box').find('#reply-vditor').remove();
    }
}

/*标题栏底部边框长度变化动画*/
function border_change(obj, length) {
    const old_width = $(obj).width();
    const changed_width = old_width + length;
    //鼠标移入底部边框增大
    $(obj).mouseenter(
        function () {
            $(this).animate({ width: changed_width });
        });
    //鼠标移出恢复原长度
    $(obj).mouseleave(function () {
        $(this).animate({ width: old_width });
    })
}

//初始化vditor
const vditor = new Vditor('vditor', {
    counter: 200,
    height: 300,
    editorName: 'vditor',
    tab: '\t',
    max: 1024,
    toolbar: ['emoji',
        'headings', 'bold', 'italic', 'strike', '|',
        'line', 'quote', 'list', 'ordered-list', 'check', 'code',
        'inline-code', 'undo', 'redo',
        // 'upload',
        'link', 'table', 'record',
        'both', 'preview', 'fullscreen', 'info', 'help', 'br'],
    upload: {
        accept: '.jpg,.png,.gif,.jpeg',
        filename(name) {
            return name.replace(/\?|\\|\/|:|\||<|>|\*|\[|\]|\s+/g, '-')
        },
        //自定义上传图片
        handler(file) {
            if ($("#user_id").val() == null || $("#user_id").val() === "") { //验证登陆
                sweetAlert("请先登录！");
                return;
            }
            let formData = new FormData(), flag = 1;
            file.forEach(f => {
                if (f.size / 1024 > 1536) { //校验图片大小
                    sweetAlert("上传图片大小不能超过1.5M");
                    flag = 0;
                    return;
                }
                formData.append('files', f, f.name);
            });
            if (flag === 1) {
                upload_img(formData);
            }
        },
    },
    preview: {
        show: true,
        parse: () => {
            LazyLoadImage()
        },
    },
    hint: {
        emoji: {
            "pray": "🙏",
            "broken_heart": "💔",
            "ok_hand": "👌",
            "smile": "😄",
            "laughing": "😆",
            "smirk": "😏",
            "heart_eyes": "😍",
            "grin": "😁",
            "stuck_out_tongue": "😛",
            "expressionless": "😑",
            "unamused": "😒",
            "sob": "😭",
            "joy": "😂",
            "tired_face": "😫",
            "blush": "😊",
            "cry": "😢",
            "fearful": "😨",
        }
    }
});

//初始化r_vditor
function init_reply_vditor() {
    return new Vditor('reply-vditor', {
        counter: 200,
        height: 200,
        editorName: 'vditor',
        tab: '\t',
        max: 1024,
        toolbar: ['emoji',
            'headings', 'bold', 'italic', 'strike', '|',
            'line', 'quote', 'list', 'ordered-list', 'check', 'code',
            'inline-code', 'undo', 'redo',
            // 'upload',
            'link',
            'both', 'preview', 'fullscreen', 'info', 'help', 'br'],
        upload: {
            accept: '.jpg,.png,.gif,.jpeg',
            filename(name) {
                return name.replace(/\?|\\|\/|:|\||<|>|\*|\[|\]|\s+/g, '-')
            },
            //自定义上传图片
            handler(file) {
                if ($("#user_id").val() == null || $("#user_id").val() === "") { //验证登陆
                    sweetAlert("请先登录！");
                    return;
                }
                let formData = new FormData(), flag = 1;
                file.forEach(f => {
                    if (f.size / 1024 > 1536) { //校验图片大小
                        sweetAlert("上传图片大小不能超过1.5M");
                        flag = 0;
                        return;
                    }
                    formData.append('files', f, f.name);
                });
                if (flag === 1) {
                    upload_img(formData);
                }
            },
        },
        preview: {
            show: true,
            mode: 'editor',
            parse: () => {
                LazyLoadImage()
            },
        },
        hint: {
            emoji: {
                "pray": "🙏",
                "broken_heart": "💔",
                "ok_hand": "👌",
                "smile": "😄",
                "laughing": "😆",
                "smirk": "😏",
                "heart_eyes": "😍",
                "grin": "😁",
                "stuck_out_tongue": "😛",
                "expressionless": "😑",
                "unamused": "😒",
                "sob": "😭",
                "joy": "😂",
                "tired_face": "😫",
                "blush": "😊",
                "cry": "😢",
                "fearful": "😨",
            }
        }
    });
}

const LazyLoadImage = () => {
    const loadImg = (it) => {
        const testImage = document.createElement('img');
        testImage.src = it.getAttribute('data-src');
        testImage.addEventListener('load', () => {
            it.src = testImage.src;
            it.style.backgroundImage = 'none';
            it.style.backgroundColor = 'transparent'
        });
        it.removeAttribute('data-src')
    };

    if (!('IntersectionObserver' in window)) {
        document.querySelectorAll('img').forEach((data) => {
            if (data.getAttribute('data-src')) {
                loadImg(data)
            }
        });
        return false
    }

    if (window.imageIntersectionObserver) {
        window.imageIntersectionObserver.disconnect();
        document.querySelectorAll('img').forEach(function (data) {
            window.imageIntersectionObserver.observe(data)
        })
    } else {
        window.imageIntersectionObserver = new IntersectionObserver((entries) => {
            entries.forEach((entrie) => {
                if ((typeof entrie.isIntersecting === 'undefined'
                    ? entrie.intersectionRatio !== 0
                    : entrie.isIntersecting) && entrie.target.getAttribute('data-src')) {
                    loadImg(entrie.target)
                }
            })
        });
        document.querySelectorAll('img').forEach(function (data) {
            window.imageIntersectionObserver.observe(data)
        })
    }
};





