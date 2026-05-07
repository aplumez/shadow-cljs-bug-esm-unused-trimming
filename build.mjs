import * as esbuild from 'esbuild'

await esbuild.build({
  ...{
    bundle: true,
    sourcemap: true,
    entryPoints: ["target/gen/libs.js"],
    outdir: "./public/js/",
    target: ["es2020", "chrome119", "firefox120", "safari17", "edge119"],
    metafile: true,
    logLevel: 'info',
    define: {
      "global": 'window',
    }
  },
  minify: true
})
