use base64ct::{Base64, Encoding};
use sha2::{Digest, Sha512};

fn hash_internal(data: &str) -> String {
    let mut hasher = Sha512::new();
    hasher.update(data);
    let hash = hasher.finalize();
    let base64_hash = Base64::encode_string(&hash);
    return base64_hash;
}

// Basic String interrop without memory management, leveraging multi-value proposal.
#[no_mangle]
pub fn hash(ptr: *mut u8, length: usize) -> (*const u8, usize) {
    let input = unsafe { String::from_raw_parts(ptr, length, length) };
    let output = hash_internal(input.as_str());
    (output.as_ptr(), output.len())
}
