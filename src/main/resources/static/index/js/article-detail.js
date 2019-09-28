$(function () {
    border_change($(".at-sort-comment-a"), 6);
});

let r_vditor;

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





