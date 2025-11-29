<#
  push_to_github.ps1
  Usage: run from the project root (PowerShell)
    .\push_to_github.ps1
    .\push_to_github.ps1 -RemoteUrl "https://github.com/user/repo.git" -CommitMessage "Initial commit"

  The script will:
  - Check if `git` is available.
  - Attempt to install Git via `winget` or `choco` if available (requires admin).
  - Initialize a git repo if none exists, create `main` branch.
  - Add and commit files (if any changes).
  - Add or update `origin` remote to the provided URL.
  - Push to `origin/main` (you may be prompted for credentials or to use a PAT).
#>

param(
    [string]$RemoteUrl = 'https://github.com/umeshvarmasunkara54-web/remote-internship.git',
    [string]$CommitMessage = 'Add JavaFX frontend for Remote Internship Management'
)

function Test-GitAvailable {
    try {
        git --version > $null 2>&1
        return $true
    } catch {
        return $false
    }
}

function Try-InstallGit {
    Write-Host "Git not found. Attempting automated install if possible..." -ForegroundColor Yellow
    if (Get-Command winget -ErrorAction SilentlyContinue) {
        Write-Host "Found winget. Installing Git via winget (may require admin)..." -ForegroundColor Cyan
        winget install --id Git.Git -e --source winget
    } elseif (Get-Command choco -ErrorAction SilentlyContinue) {
        Write-Host "Found Chocolatey. Installing Git via choco (may require admin)..." -ForegroundColor Cyan
        choco install git -y
    } else {
        Write-Host "Automatic install not available. Please install Git manually: https://git-scm.com/download/win" -ForegroundColor Red
        return $false
    }
    return Test-GitAvailable
}

Write-Host "Running push_to_github.ps1" -ForegroundColor Green

if (-not (Test-GitAvailable)) {
    $ok = Read-Host "Git is not installed. Try to install automatically? (y/n)"
    if ($ok -eq 'y') {
        $installed = Try-InstallGit
        if (-not $installed) {
            Write-Host "Git installation failed or not available. Aborting." -ForegroundColor Red
            exit 1
        }
    } else {
        Write-Host "Please install Git and re-run this script. https://git-scm.com/download/win" -ForegroundColor Yellow
        exit 1
    }
}

# Ensure we're in project root (where this script is located) unless user ran from elsewhere
Push-Location -LiteralPath (Split-Path -Path $MyInvocation.MyCommand.Definition -Parent)

try {
    if (-not (Test-Path .git)) {
        Write-Host "Initializing git repository..." -ForegroundColor Cyan
        git init
        git branch -M main
    } else {
        Write-Host ".git already exists." -ForegroundColor Gray
    }

    Write-Host "Staging files..." -ForegroundColor Cyan
    git add .

    $status = git status --porcelain
    if ($status) {
        Write-Host "Committing changes..." -ForegroundColor Cyan
        git commit -m "$CommitMessage"
    } else {
        Write-Host "No changes to commit." -ForegroundColor Gray
    }

    $existingRemote = git remote get-url origin 2>$null
    if ($existingRemote) {
        if ($existingRemote -ne $RemoteUrl) {
            $resp = Read-Host "Remote 'origin' exists with URL '$existingRemote'. Replace with '$RemoteUrl'? (y/n)"
            if ($resp -eq 'y') {
                git remote set-url origin $RemoteUrl
            } else {
                Write-Host "Keeping existing remote URL: $existingRemote" -ForegroundColor Yellow
            }
        } else {
            Write-Host "Remote 'origin' already set to the target URL." -ForegroundColor Gray
        }
    } else {
        Write-Host "Adding remote origin -> $RemoteUrl" -ForegroundColor Cyan
        git remote add origin $RemoteUrl
    }

    Write-Host "Pushing to origin/main..." -ForegroundColor Cyan
    git push -u origin main
    Write-Host "Push completed. If authentication failed, use a GitHub Personal Access Token (PAT) when prompted." -ForegroundColor Green
} catch {
    Write-Host "An error occurred: $_" -ForegroundColor Red
    exit 1
} finally {
    Pop-Location
}
