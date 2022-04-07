const about = document.querySelector('#about')
const contact = document.querySelector('#contact')
const aboutContent = document.querySelector('#about-content')
const contactContent = document.querySelector('#contact-content')

about.addEventListener('click', () => {
    const aboutBox = new WinBox({
        title: 'Students REST',
        // modal: true,
        width: '600px',
        height: '400px',
        top: 50,
        right: 50,
        bottom: 50,
        left: 50,
        mount: aboutContent,
        onfocus: function () {
            this.setBackground('#00aa00')
        },
        onblur: function () {
            this.setBackground('#777')
        },
    })
})

contact.addEventListener('click', () => {
    const contactBox = new WinBox({
        title: 'Professors REST',
        width: '600px',
        height: '400px',
        top: 50,
        right: 0,
        bottom: 50,
        left: 250,
        mount: contactContent,
        onfocus: function () {
            this.setBackground('#00aa00')
        },
        onblur: function () {
            this.setBackground('#777')
        },
    })
})