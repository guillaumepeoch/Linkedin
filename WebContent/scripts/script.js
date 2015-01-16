$(document).ready(function() {
    var panels = $('.user-infos');
    var panelsButton = $('.dropdown-user');
    panels.hide();

    //Click dropdown
    panelsButton.click(function() {
        //get data-for attribute
        var dataFor = $(this).attr('data-for');
        var idFor = $(dataFor);

        //current button
        var currentButton = $(this);
        idFor.slideToggle(400, function() {
            //Completed slidetoggle
            if(idFor.is(':visible'))
            {
                currentButton.html('<i class="glyphicon glyphicon-chevron-up text-muted"></i>'); 
            }
            else
            {
                currentButton.html('<i class="glyphicon glyphicon-chevron-down text-muted"></i>');
            }
        })
    });


    $('[data-toggle="tooltip"]').tooltip();

    $('button').click(function(e) {
        e.preventDefault();
        alert("This is a demo.\n :-)");
    });
});




// Inutile.... pour linstant!


/*
$(document).ready(function(){

    // click on confirm
    $('#confirm').click(function(){

        console.log('confirm1');

        // add to the friend list
        var aAjouter = $('label').val();

        $('#friend').append('

            <li class="list-group-item"><label> '+aAjouter+' </label>
                    <div class="pull-right action-buttons">
                        <a href="#"><span class="glyphicon glyphicon-pencil"></span></a> <a
                            href="#" class="trash"><span
                            class="glyphicon glyphicon-trash"></span></a>
                    </div></li>


            ');

        $(this).remove();
        });

        



    // remove from friend request list
    $(document).on('click','.list-group-item',function(){
        console.log('confirm2');
        $(this).remove();
       });

       });
});

*/
