# Auto Git Commit and Push Script
# This script automatically adds all changes, commits with "Work done" message, and pushes to remote

Write-Host "Starting auto git operations..." -ForegroundColor Green

# Add all changes
Write-Host "Adding all changes..." -ForegroundColor Yellow
git add .

# Check if there are any changes to commit
$status = git status --porcelain
if ($status) {
    # Commit with message
    Write-Host "Committing changes..." -ForegroundColor Yellow
    git commit -m "Work done"
    
    # Push to remote
    Write-Host "Pushing to remote..." -ForegroundColor Yellow
    git push
    
    Write-Host "All operations completed successfully!" -ForegroundColor Green
} else {
    Write-Host "No changes to commit." -ForegroundColor Cyan
}

Write-Host "Script finished." -ForegroundColor Blue
