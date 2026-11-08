$archivo = "C:\Users\Public\inicio_sesion.txt"
$registro = "$(Get-Date -Format 'yyyy-MM-dd HH:mm:ss') - Usuario: $env:USERNAME"

Add-Content -Path $archivo -Value $registro