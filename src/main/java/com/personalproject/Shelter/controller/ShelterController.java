package com.personalproject.Shelter.controller;



@Validated
@RestController
public class ShelterController {

    private final ShelterService shelterService;

    public ShelterController(ShelterService shelterService) {
        this.shelterService = shelterService;
    }

    @DeleteMapping( value= "/shelter/{id}")
    public void deleteShelterbyId(@PathVariable(name = "id") Long id) {
        shelterService.deleteById(id);
    }

    @GetMapping("/shelter/{id}")
    public ShelterReturnResponse existsById(Long id) {
        Shelter shelter = shelterService.findById(id);
        ShelterReturnResponse shelterResponse = new ShelterReturnResponse(
                shelter.getId(),
                shelter.getName(),
                shelter.getCapacity(),
                shelter.getShelterColor());
        return shelterResponse;
    }

    @GetMapping("/shelter/{name}")
    public ShelterReturnResponse getShelterByName(String name) {
        Shelter shelter = shelterService.findByNameContaining(name);
        ShelterReturnResponse shelterResponse = new ShelterReturnResponse(
                shelter.getId(),
                shelter.getName(),
                shelter.getCapacity(),
                shelter.getShelterColor());
        return shelterResponse;
    }
    @PostMapping(value = "/shelter")
    public ShelterReturnResponse addShelter(@RequestBody CreateShelterRQ shelterReq) {
        Shelter shelter = Shelter
                .builder()
                .name(shelterReq.getName())
                .capacity(shelterReq.getCapacity())
                .shelterColor(shelterReq.getShelterColor())
                .build();
        shelterService.save(shelter);
        ShelterReturnResponse shelterResp = new ShelterReturnResponse();
        shelterResp.setId(shelter.getId());
        shelterResp.setName(shelter.getName());
        shelterResp.setCapacity(shelter.getCapacity());
        shelterResp.setShelterColor(shelter.getShelterColor());
        return shelterResp;
    }
    @PostMapping(value = "/shelter/{id}/pets")
    public ShelterPetReturnResponse createPetOnShelter(@RequestBody List<CreatePetRQ> petList, Long id) {
        List<Pet> pets = new ArrayList<>();
        for (CreatePetRQ petReq : petList) {
            pets.add(Pet
                    .builder()
                    .petType(petReq.getPetType())
                    .name(petReq.getName())
                    .build());
        }
        Shelter shelter = PetService.saveinshelter(pets, id);
        List<PetReturnResponse> petResps = new ArrayList<>();
        ShelterPetReturnResponse shelterPetReturnResponse =
                new ShelterPetReturnResponse(shelter.getId(), shelter.getName()
                        , shelter.getCapacity(), shelter.getShelterColor(), petResps);
        for (Pet pet : shelter.getPets()) {
            PetReturnResponse PetReturnResponse = new PetReturnResponse(
                    pet.getId(),
                    pet.getPetType(),
                    pet.getName());
            shelterPetReturnResponse.getPetReturnResponseList().add(PetReturnResponse);
        }
        return shelterPetReturnResponse;
    }
}