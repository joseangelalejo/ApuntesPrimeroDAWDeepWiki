$escritorio = [Environment]::GetFolderPath('Desktop')
$fecha = Get-Date -Format "yyyy-MM-dd"
$carpeta = Join-Path $escritorio $fecha

New-Item -Path $carpeta -ItemType Directory -Force | Out-Null