const dropArea = document.getElementById('drop-area');
const fileInput = document.getElementById('fileElem');
const preview = document.getElementById('preview');
const titleInput = document.getElementById('title-input');
const uploadButton = document.getElementById('upload-button');

const fileElem = document.getElementById('fileElem');
  const browseButton = document.getElementById('browse-button');

  browseButton.addEventListener('click', function() {
    fileElem.click();
  });

  fileElem.addEventListener('change', function() {
    handleFiles(fileElem.files);
  });


dropArea.addEventListener('dragover', function(e) {
  e.preventDefault();
  dropArea.classList.add('dragover');
});

dropArea.addEventListener('dragleave', function() {
  dropArea.classList.remove('dragover');
});

dropArea.addEventListener('drop', function(e) {
  e.preventDefault();
  dropArea.classList.remove('dragover');
  handleFiles(e.dataTransfer.files);
});
fileInput.addEventListener('change', function() {
  handleFiles(fileInput.files);
});

function handleFiles(files) {
  const file = files[0];
  if (file) {
    if (file.type.startsWith('image/')) {
      const reader = new FileReader();

      reader.onload = function(e) {
        preview.src = e.target.result;
        preview.style.display = 'block';
        titleInput.style.display = 'block';
        uploadButton.style.display = 'block';
      };

      reader.readAsDataURL(file);
    } else {
      alert('Please select an image file.');
    }
  }
}

uploadButton.addEventListener('click', function() {
  const title = titleInput.value;
  if (title.trim() === '') {
    alert('Please enter a title for the image.');
  } else {
    // Aqui você pode adicionar sua lógica para fazer o upload da imagem e do título.
    // Você pode enviar esses dados para o servidor usando AJAX ou outro método.
    alert('Image and title uploaded: ' + title);
    clearForm();
  }
});

function clearForm() {
  fileInput.value = '';
  preview.style.display = 'none';
  titleInput.style.display = 'none';
  uploadButton.style.display = 'none';
  titleInput.value = '';
}

