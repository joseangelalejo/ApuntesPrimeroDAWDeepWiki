$origen = "C:\Datos"
$destino = "C:\Recovery"

if (!(Test-Path $destino)) {
    New-Item -Path $destino -ItemType Directory | Out-Null
}

Copy-Item -Path "$origen\*" -Destination $destino -Recurse -Force