// Confirm delete dialog
function confirmDelete(form) {
    const confirmed = window.confirm('Tem certeza que deseja excluir este produto? Esta ação não pode ser desfeita.');
    return confirmed;
}

// Auto-hide alerts after 4s
document.addEventListener('DOMContentLoaded', () => {
    const alerts = document.querySelectorAll('.alert');
    alerts.forEach(alert => {
        setTimeout(() => {
            alert.style.transition = 'opacity .5s ease';
            alert.style.opacity = '0';
            setTimeout(() => alert.remove(), 500);
        }, 4000);
    });
});
