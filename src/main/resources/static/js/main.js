feather.replace();
jQuery(function ($) {
    let $datePicker = $('#datepicker');
    if ($datePicker.datepicker) {
        $datePicker.datepicker({format: 'yyyy-mm-dd'});
    }
    const $createForm = $('#createForm');
    if ($createForm.validate) {
        $createForm.validate({
            rules: {
                title: {
                    required: true
                },
                category: {
                    required: true
                },
                authorFirstName: {
                    required: true
                },
                authorLastName: {
                    required: true
                },
                publicationDate: {
                    required: true
                },
                isbn: {
                    required: true,
                    digits: true,
                    minlength: 10,
                    maxlength: 10
                }
            },
            messages: {
                title: {
                    required: "Title is required."
                },
                isbn: {
                    minlength: "It should be exactly 10 digits.",
                    maxlength: "It should be exactly 10 digits."
                }
            }
        });
    }


    $('#modal').on('show.bs.modal', function (event) {
        const id = event.relatedTarget.dataset.id;
        $('#deleteForm').attr('action', `/books/${id}/delete`);
        $('.modal-title').text(function () {
            return `Book #${id}`;
        });
    });
});