// ========================
// VALIDACIÓN DEL FORMULARIO
// ========================

const inputNombre = document.querySelector('input[type="text"]');

// Creamos un mensaje de error debajo del campo
const mensajeError = document.createElement('p');
mensajeError.textContent = '⚠️ El nombre no puede contener números';
mensajeError.style.cssText = 'color: #c8a96e; font-size: 0.78rem; margin-top: 0.4rem; display: none;';
inputNombre.parentNode.appendChild(mensajeError);

inputNombre.addEventListener('input', () => {
  const tieneNumeros = /[0-9]/.test(inputNombre.value);

  if (tieneNumeros) {
    // Borra los números
    inputNombre.value = inputNombre.value.replace(/[0-9]/g, '');
    // Muestra el mensaje de error
    mensajeError.style.display = 'block';
  } else {
    // Oculta el mensaje si no hay números
    mensajeError.style.display = 'none';
  }
});
// ========================
// ANIMACIÓN "ENVIADO!"
// ========================
const botonEnviar = document.querySelector('#contacto .btn');

// Creamos el mensaje
const mensajeEnviado = document.createElement('p');
mensajeEnviado.textContent = '✓ ¡Enviado!';
mensajeEnviado.style.cssText = `
  color: #c8a96e;
  font-size: 1rem;
  font-weight: 500;
  margin-top: 1rem;
  opacity: 0;
  transform: translateX(60px);
  transition: all 0.6s ease;
`;
botonEnviar.parentNode.appendChild(mensajeEnviado);

botonEnviar.addEventListener('click', () => {
  // Entra desde la derecha hacia la izquierda
  mensajeEnviado.style.opacity = '1';
  mensajeEnviado.style.transform = 'translateX(0)';

  // Se va después de 3 segundos
  setTimeout(() => {
    mensajeEnviado.style.opacity = '0';
    mensajeEnviado.style.transform = 'translateX(60px)';
  }, 3000);
});

// Creamos el mensaje de confirmación
const mensajeEnviado = document.createElement('p');
mensajeEnviado.textContent = '✓ ¡Enviado!';
mensajeEnviado.style.cssText = `
  color: #c8a96e;
  font-size: 1rem;
  font-weight: 500;
  margin-top: 1rem;
  opacity: 0;
  transform: translateX(-60px);
  transition: all 0.6s ease;
`;
botonEnviar.parentNode.appendChild(mensajeEnviado);

// Cuando se hace clic en "Enviar mensaje"
botonEnviar.addEventListener('click', () => {
  // Activa la animación
  mensajeEnviado.style.opacity = '1';
  mensajeEnviado.style.transform = 'translateX(0)';

  // Lo oculta de nuevo después de 3 segundos
  setTimeout(() => {
    mensajeEnviado.style.opacity = '0';
    mensajeEnviado.style.transform = 'translateX(-60px)';
  }, 3000);
});