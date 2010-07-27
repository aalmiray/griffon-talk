root {
    'groovy.swing.SwingBuilder' {
        controller = ['Threading']
        view = '*'
    }
    'griffon.app.ApplicationBuilder' {
        view = '*'
    }
}
root.'griffon.builder.trident.TridentBuilder'.view = '*'

jx {
    'groovy.swing.SwingXBuilder' {
        view = '*'
        controller = ['withWorker']
    }
}

root.'griffon.builder.jide.JideBuilder'.view = '*'
root.'griffon.builder.gfx.GfxBuilder'.view = '*'
root.'griffon.builder.css.CSSBuilder'.view = '*'
root.'griffon.builder.css.CSSBuilder'.controller = ['CSS']
root.'TransitionsGriffonAddon'.addon=true
